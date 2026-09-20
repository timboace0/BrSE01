package bussiness.dao;

import bussiness.model.OrderDetail;
import bussiness.model.Product;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public void createOrder(String customerName, List<OrderDetail> orderDetails) {

        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            for (OrderDetail detail : orderDetails) {

                String checkStockSql = """
                        SELECT stock_quantity
                        FROM product
                        WHERE id = ?
                        FOR UPDATE
                        """;

                PreparedStatement checkStock =
                        conn.prepareStatement(checkStockSql);

                checkStock.setInt(1, detail.getProductId());

                ResultSet rs = checkStock.executeQuery();

                if (!rs.next()) {
                    throw new RuntimeException(
                            "Sản phẩm ID " + detail.getProductId() + " không tồn tại!"
                    );
                }

                int stock = rs.getInt("stock_quantity");

                if (stock < detail.getQuantity()) {
                    throw new RuntimeException(
                            "Sản phẩm ID " + detail.getProductId() +
                                    " không đủ số lượng!"
                    );
                }
            }

            String orderSql = """
                    INSERT INTO orders(customer_name, order_date)
                    VALUES (?, ?)
                    """;

            PreparedStatement orderStatement =
                    conn.prepareStatement(
                            orderSql,
                            Statement.RETURN_GENERATED_KEYS
                    );

            orderStatement.setString(1, customerName);
            orderStatement.setDate(2, new Date(System.currentTimeMillis()));

            orderStatement.executeUpdate();

            ResultSet generatedKeys =
                    orderStatement.getGeneratedKeys();

            if (!generatedKeys.next()) {
                throw new RuntimeException("Không thể tạo đơn hàng!");
            }

            int orderId = generatedKeys.getInt(1);

            String detailSql = """
                    INSERT INTO order_details(order_id, product_id, quantity)
                    VALUES (?, ?, ?)
                    """;

            PreparedStatement detailStatement =
                    conn.prepareStatement(detailSql);

            String updateStockSql = """
                    UPDATE product
                    SET stock_quantity = stock_quantity - ?
                    WHERE id = ?
                    """;

            PreparedStatement stockStatement =
                    conn.prepareStatement(updateStockSql);

            for (OrderDetail detail : orderDetails) {

                detailStatement.setInt(1, orderId);
                detailStatement.setInt(2, detail.getProductId());
                detailStatement.setInt(3, detail.getQuantity());

                detailStatement.executeUpdate();

                stockStatement.setInt(1, detail.getQuantity());
                stockStatement.setInt(2, detail.getProductId());

                stockStatement.executeUpdate();
            }

            conn.commit();

            System.out.println("Tạo đơn hàng thành công!");

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void updateProductStock(int productId, int quantity) {

        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            String sql = """
                    SELECT stock_quantity
                    FROM product
                    WHERE id = ?
                    FOR UPDATE
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Sản phẩm không tồn tại!");
            }

            int stock = rs.getInt("stock_quantity");

            if (stock < quantity) {
                throw new RuntimeException("Số lượng sản phẩm không đủ!");
            }

            String updateSql = """
                    UPDATE product
                    SET stock_quantity = stock_quantity - ?
                    WHERE id = ?
                    """;

            PreparedStatement update =
                    conn.prepareStatement(updateSql);

            update.setInt(1, quantity);
            update.setInt(2, productId);

            update.executeUpdate();

            conn.commit();

            System.out.println("Cập nhật số lượng sản phẩm thành công!");

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Product> listProducts() {

        Connection conn = ConnectionDB.openConnection();

        List<Product> products = new ArrayList<>();

        try {

            String sql = """
                    SELECT id, name, price, stock_quantity
                    FROM product
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBigDecimal("price"),
                        rs.getInt("stock_quantity")
                );

                products.add(product);
            }

            return products;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
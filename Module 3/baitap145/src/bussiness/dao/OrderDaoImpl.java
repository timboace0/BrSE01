package bussiness.dao;

import bussiness.model.Product;
import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public void placeOrder(int customerId, BigDecimal totalAmount, int productId, int quantity) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            CallableStatement getProduct = conn.prepareCall("{CALL getProductById(?)}");

            getProduct.setInt(1, productId);

            ResultSet rs = getProduct.executeQuery();

            if (!rs.next()) {
                throw new RuntimeException("Không tìm thấy sản phẩm!");
            }

            int stock = rs.getInt("stock");

            if (stock < quantity) {
                throw new RuntimeException("Không đủ hàng trong kho!");
            }

            int newStock = stock - quantity;

            CallableStatement orderCall = conn.prepareCall("{CALL place_order(?,?,?,?)}");

            orderCall.setInt(1, customerId);
            orderCall.setBigDecimal(2, totalAmount);
            orderCall.setInt(3, productId);
            orderCall.setInt(4, quantity);

            orderCall.executeUpdate();

            CallableStatement stockCall = conn.prepareCall("{CALL saveStockProduct(?,?)}");

            stockCall.setInt(1, productId);
            stockCall.setInt(2, newStock);

            stockCall.executeUpdate();

            conn.commit();

            System.out.println("Đặt hàng thành công!");

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
}
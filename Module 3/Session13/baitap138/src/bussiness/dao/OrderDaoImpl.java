package bussiness.dao;

import bussiness.model.Customer;
import bussiness.model.Order;
import bussiness.model.Product;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public boolean addProduct(Product product) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL add_product(?,?)}");

            call.setString(1, product.getName());
            call.setBigDecimal(2, product.getPrice());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean updateCustomer(int customerId, Customer customer) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL update_customer(?,?,?)}");

            call.setInt(1, customerId);
            call.setString(2, customer.getName());
            call.setString(3, customer.getEmail());

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public boolean createOrder(int customerId, int productId, int quantity) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL create_order(?,?,?)}");

            call.setInt(1, customerId);
            call.setInt(2, productId);
            call.setInt(3, quantity);

            call.executeUpdate();

            return true;

        } catch (SQLException e) {
            if ("45000".equals(e.getSQLState())) {
                return false;
            }

            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Order> listAllOrders() {
        List<Order> orders = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL list_all_orders()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getDate("order_date").toLocalDate(),
                        rs.getBigDecimal("total_amount")
                );

                orders.add(order);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return orders;
    }

    @Override
    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> orders = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL get_orders_by_customer(?)}");

            call.setInt(1, customerId);

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getString("customer_name"),
                        rs.getDate("order_date").toLocalDate(),
                        rs.getBigDecimal("total_amount")
                );

                orders.add(order);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return orders;
    }
}
package bussiness.dao;

import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.*;

public class BankTransferDaoImpl implements IBankTransferDao{
    @Override
    public void transfer(int id_from, int id_to, BigDecimal amount) {
        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            if (!accountExists(conn, id_from)) {
                throw new RuntimeException("Không tìm thấy tài khoản người gửi!");
            }

            if (!accountExists(conn, id_to)) {
                throw new RuntimeException("Không tìm thấy tài khoản người nhận!");
            }

            BigDecimal balance = getBalance(conn, id_from);

            if (balance.compareTo(amount) < 0) {
                throw new RuntimeException("Số dư không đủ!");
            }

            CallableStatement call1 =
                    conn.prepareCall("{CALL transfer_funds(?,?)}");

            call1.setInt(1, id_from);
            call1.setBigDecimal(2, amount.negate());
            call1.executeUpdate();

            CallableStatement call2 =
                    conn.prepareCall("{CALL transfer_funds(?,?)}");

            call2.setInt(1, id_to);
            call2.setBigDecimal(2, amount);
            call2.executeUpdate();

            conn.commit();

            System.out.println("Chuyển tiền thành công!");

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            System.out.println(e.getMessage());

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    public boolean accountExists(Connection conn, int id) throws SQLException {
        String sql = "SELECT id FROM accounts WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    private BigDecimal getBalance(Connection conn, int id) throws SQLException {
        String sql = "SELECT balance FROM accounts WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getBigDecimal("balance");
        }

        return null;
    }
}

package bussiness.dao;

import bussiness.model.Account;
import bussiness.model.Transaction;
import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements IBankDao {

    @Override
    public void transferMoney(int fromAccountId, int toAccountId, double amount) {

        Connection conn = ConnectionDB.openConnection();

        try {
            conn.setAutoCommit(false);

            if (fromAccountId == toAccountId) {
                throw new RuntimeException("Tài khoản gửi và nhận không được giống nhau!");
            }

            if (amount <= 0) {
                throw new RuntimeException("Số tiền chuyển phải lớn hơn 0!");
            }

            String selectSql = """
                    SELECT id, account_number, balance
                    FROM account
                    WHERE id = ?
                    FOR UPDATE
                    """;

            PreparedStatement selectFrom = conn.prepareStatement(selectSql);
            selectFrom.setInt(1, fromAccountId);

            ResultSet rsFrom = selectFrom.executeQuery();

            if (!rsFrom.next()) {
                throw new RuntimeException("Tài khoản người gửi không tồn tại!");
            }

            BigDecimal fromBalance = rsFrom.getBigDecimal("balance");

            PreparedStatement selectTo = conn.prepareStatement(selectSql);
            selectTo.setInt(1, toAccountId);

            ResultSet rsTo = selectTo.executeQuery();

            if (!rsTo.next()) {
                throw new RuntimeException("Tài khoản người nhận không tồn tại!");
            }

            BigDecimal transferAmount = BigDecimal.valueOf(amount);

            if (fromBalance.compareTo(transferAmount) < 0) {
                throw new RuntimeException("Số dư không đủ!");
            }

            String updateFromSql = """
                    UPDATE account
                    SET balance = balance - ?
                    WHERE id = ?
                    """;

            PreparedStatement updateFrom = conn.prepareStatement(updateFromSql);

            updateFrom.setBigDecimal(1, transferAmount);
            updateFrom.setInt(2, fromAccountId);

            updateFrom.executeUpdate();

            String updateToSql = """
                    UPDATE account
                    SET balance = balance + ?
                    WHERE id = ?
                    """;

            PreparedStatement updateTo = conn.prepareStatement(updateToSql);

            updateTo.setBigDecimal(1, transferAmount);
            updateTo.setInt(2, toAccountId);

            updateTo.executeUpdate();

            String insertTransactionSql = """
                    INSERT INTO bank_transactions(
                        from_account_id,
                        to_account_id,
                        amount,
                        transaction_date
                    )
                    VALUES (?, ?, ?, NOW())
                    """;

            PreparedStatement insertTransaction =
                    conn.prepareStatement(insertTransactionSql);

            insertTransaction.setInt(1, fromAccountId);
            insertTransaction.setInt(2, toAccountId);
            insertTransaction.setBigDecimal(3, transferAmount);

            insertTransaction.executeUpdate();

            conn.commit();

            System.out.println("Chuyển tiền thành công!");

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
    public Account getAccountInfo(int accountId) {

        Connection conn = ConnectionDB.openConnection();

        try {
            String sql = """
                    SELECT id, account_number, balance
                    FROM account
                    WHERE id = ?
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getInt("id"),
                        rs.getString("account_number"),
                        rs.getBigDecimal("balance")
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Transaction> listTransactions(int accountId) {

        Connection conn = ConnectionDB.openConnection();

        List<Transaction> transactions = new ArrayList<>();

        try {
            String sql = """
                    SELECT id,
                           from_account_id,
                           to_account_id,
                           amount,
                           transaction_date
                    FROM bank_transactions
                    WHERE from_account_id = ?
                       OR to_account_id = ?
                    ORDER BY transaction_date DESC
                    """;

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);
            ps.setInt(2, accountId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getInt("from_account_id"),
                        rs.getInt("to_account_id"),
                        rs.getBigDecimal("amount"),
                        rs.getTimestamp("transaction_date")
                );

                transactions.add(transaction);
            }

            return transactions;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }
}
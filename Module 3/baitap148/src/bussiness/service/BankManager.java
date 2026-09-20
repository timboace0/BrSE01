package bussiness.service;

import bussiness.dao.BankDaoImpl;
import bussiness.dao.IBankDao;
import bussiness.model.Account;
import bussiness.model.Transaction;

import java.util.List;

public class BankManager {

    private IBankDao bankDao = new BankDaoImpl();

    public void transferMoney(int fromAccountId, int toAccountId, double amount) {
        bankDao.transferMoney(fromAccountId, toAccountId, amount);
    }

    public void getAccountInfo(int accountId) {

        Account account = bankDao.getAccountInfo(accountId);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại!");
            return;
        }

        System.out.println(account);
    }

    public void listTransactions(int accountId) {

        Account account = bankDao.getAccountInfo(accountId);

        if (account == null) {
            System.out.println("Tài khoản không tồn tại!");
            return;
        }

        List<Transaction> transactions =
                bankDao.listTransactions(accountId);

        if (transactions.isEmpty()) {
            System.out.println("Tài khoản chưa có giao dịch!");
            return;
        }

        System.out.println("""
                
                ========== LỊCH SỬ GIAO DỊCH ==========
                """);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
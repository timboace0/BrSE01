package bussiness.dao;

import bussiness.model.Account;
import bussiness.model.Transaction;

import java.util.List;

public interface IBankDao {

    void transferMoney(int fromAccountId, int toAccountId, double amount);

    Account getAccountInfo(int accountId);

    List<Transaction> listTransactions(int accountId);
}
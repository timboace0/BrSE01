package bussiness.service;

import bussiness.dao.BankTransferDaoImpl;
import bussiness.dao.IBankTransferDao;

import java.math.BigDecimal;

public class BankManager {
    public static void transferFunds(int id_from, int id_to, BigDecimal amount){
        IBankTransferDao banks = new BankTransferDaoImpl();
        banks.transfer(id_from, id_to,amount);
    }
}

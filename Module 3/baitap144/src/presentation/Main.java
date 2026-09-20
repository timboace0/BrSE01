package presentation;

import bussiness.service.BankManager;
import utils.ConnectionDB;

import java.math.BigDecimal;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Connection conn = ConnectionDB.openConnection();
//        if(conn!= null){
//            System.out.println("Thành công!");
//        }

        BankManager.transferFunds(
                1,
                2,
                new BigDecimal("1000000")
        );
    }
}
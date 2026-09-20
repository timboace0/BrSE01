package bussiness.dao;

import java.math.BigDecimal;

public interface IBankTransferDao {
    void transfer(int id_from, int id_to, BigDecimal amount);
}

package com.example.payment.repository;

import java.math.BigDecimal;

public interface UserBalanceRepository {
    BigDecimal getBalance(String userId);
    void updateBalance(String userId, BigDecimal newBalance);
}

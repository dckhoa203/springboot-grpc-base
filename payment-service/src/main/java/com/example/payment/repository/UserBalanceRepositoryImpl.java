package com.example.payment.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class UserBalanceRepositoryImpl implements UserBalanceRepository {
    private final UserBalanceMapper userBalanceMapper;

    @Autowired
    public UserBalanceRepositoryImpl(UserBalanceMapper userBalanceMapper) {
        this.userBalanceMapper = userBalanceMapper;
    }

    public BigDecimal getBalance(String userId) {
        return userBalanceMapper.getBalance(userId);
    }

    public void updateBalance(String userId, BigDecimal newBalance) {
         userBalanceMapper.updateBalance(userId, newBalance);
    }
}

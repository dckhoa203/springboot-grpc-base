package com.example.payment.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Mapper
@Component
public interface UserBalanceMapper {

    @Select("SELECT balance FROM user_balance WHERE user_id = #{userId}")
    BigDecimal getBalance(@Param("userId") String userId);

    @Update("UPDATE user_balance SET balance = #{newBalance} WHERE user_id = #{userId}")
    void updateBalance(@Param("userId") String userId, @Param("newBalance") BigDecimal newBalance);
}

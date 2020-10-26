package com.test.demo.mapper;

import com.test.demo.entity.BankCard;

public interface BankCardMapper {
    int deleteByPrimaryKey(String bNumber);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    BankCard selectByPrimaryKey(String bNumber);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}
package com.test.demo.mapper;

import com.test.demo.entity.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
}
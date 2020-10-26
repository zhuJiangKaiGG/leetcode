package com.test.demo.mapper;

import com.test.demo.entity.Insurance;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);
}
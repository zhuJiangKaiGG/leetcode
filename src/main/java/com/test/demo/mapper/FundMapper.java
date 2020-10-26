package com.test.demo.mapper;

import com.test.demo.entity.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}
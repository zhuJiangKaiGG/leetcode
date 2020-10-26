package com.test.demo.mapper;

import com.test.demo.entity.Property;

public interface PropertyMapper {
    int deleteByPrimaryKey(Integer proId);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Integer proId);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}
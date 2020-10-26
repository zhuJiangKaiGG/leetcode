package com.test.demo.mapper;

import com.test.demo.entity.FinancesProduct;

public interface FinancesProductMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(FinancesProduct record);

    int insertSelective(FinancesProduct record);

    FinancesProduct selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(FinancesProduct record);

    int updateByPrimaryKeyWithBLOBs(FinancesProduct record);

    int updateByPrimaryKey(FinancesProduct record);
}
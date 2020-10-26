package com.test.demo.test.decoratorattern;

import java.math.BigDecimal;

/**
 * @Author :zjk
 * @Date :Create in 10:21 2020-10-07
 * @Description 低咖啡因咖啡
 **/
public class Decaf extends Beverage {
    private final String PRICE = "3.00";
    public Decaf(){
        description = "Decaf";
    }
    @Override
    public BigDecimal cost() {
        return new BigDecimal(PRICE);
    }
}

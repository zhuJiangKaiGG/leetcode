package com.test.demo.test.decoratorattern;

import java.math.BigDecimal;

/**
 * @Author :zjk
 * @Date :Create in 10:15 2020-10-07
 * @Description 深焙咖啡
 **/
public class DarkRoast extends Beverage {
    public final String PRICE = "2.00";
    public DarkRoast(){
        description = "DarkRoast";
    }
    @Override
    public BigDecimal cost() {
        return new BigDecimal(PRICE);
    }
}

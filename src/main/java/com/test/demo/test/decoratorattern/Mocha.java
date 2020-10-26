package com.test.demo.test.decoratorattern;

import java.math.BigDecimal;

/**
 * @Author :zjk
 * @Date :Create in 10:25 2020-10-07
 * @Description 摩卡调料
 **/
public class Mocha extends CondimentDecorator {
    Beverage beverage;
    private final String PRICE = "0.2";
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        System.out.println("1"+beverage.getDescription());

        return beverage.getDescription()+",Mocha";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(PRICE).add(beverage.cost());
    }
}

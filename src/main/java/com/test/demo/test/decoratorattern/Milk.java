package com.test.demo.test.decoratorattern;

import java.math.BigDecimal;

/**
 * @Author :zjk
 * @Date :Create in 10:28 2020-10-07
 * @Description 牛奶调料
 **/
public class Milk extends CondimentDecorator {
    //将需要装饰的饮料封装在装饰类中
    Beverage beverage;
    private final String PRICE = "0.3";

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+",Milk";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(PRICE).add(beverage.cost());
    }
}

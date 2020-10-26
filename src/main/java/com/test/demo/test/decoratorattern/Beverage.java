package com.test.demo.test.decoratorattern;

import java.math.BigDecimal;

/**
 * @Author :zjk
 * @Date :Create in 10:09 2020-10-07
 * @Description 饮料抽象类
 **/
public abstract class Beverage {
     String description = "Unknown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract BigDecimal cost();
}

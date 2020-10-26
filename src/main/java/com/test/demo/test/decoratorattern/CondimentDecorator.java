package com.test.demo.test.decoratorattern;

/**
 * @Author :zjk
 * @Date :Create in 10:23 2020-10-07
 * @Description 调料装饰着抽象类
 **/
public abstract class CondimentDecorator extends Beverage{
    /**
     * 所有的调料装饰者都必须”重新实现“getDescription()方法
     * 这样才能够用递归的方式来得到所选饮料的整体描述
     */
    public abstract String getDescription();
}

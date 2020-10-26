package com.test.demo.controller;

import com.test.demo.test.SingletonTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author :zjk
 * @Date :Create in 8:36 2020-09-30
 * @Description 单例模式测试
 **/
@Controller
@RequestMapping("/singleton")
public class SingletonController {
    @RequestMapping("/first")
    public void first() {
        SingletonTest instance = SingletonTest.getInstance();
        instance.setName("张三");
        System.out.println("first:"+instance.getName());
    }
    @RequestMapping("/second")
    public void second() {
        SingletonTest instance = SingletonTest.getInstance();
        System.out.println("second"+instance.getName());
    }
}

package com.test.demo.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Student {
    private Integer stdId;

    private String stdName;

    private String stdSex;

    private Date stdBirth;

    private Date stdIn;

    private String stdAddress;

}

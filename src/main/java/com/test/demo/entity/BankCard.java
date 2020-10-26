package com.test.demo.entity;

public class BankCard {
    private String bNumber;

    private String bType;

    private Integer bCId;

    public String getbNumber() {
        return bNumber;
    }

    public void setbNumber(String bNumber) {
        this.bNumber = bNumber == null ? null : bNumber.trim();
    }

    public String getbType() {
        return bType;
    }

    public void setbType(String bType) {
        this.bType = bType == null ? null : bType.trim();
    }

    public Integer getbCId() {
        return bCId;
    }

    public void setbCId(Integer bCId) {
        this.bCId = bCId;
    }
}
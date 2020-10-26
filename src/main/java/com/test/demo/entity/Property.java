package com.test.demo.entity;

import java.util.Date;

public class Property {
    private Integer proId;

    private Integer proCId;

    private String proStatus;

    private Integer proQuantity;

    private Integer proIncome;

    private Date proPurchaseTime;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getProCId() {
        return proCId;
    }

    public void setProCId(Integer proCId) {
        this.proCId = proCId;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus == null ? null : proStatus.trim();
    }

    public Integer getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(Integer proQuantity) {
        this.proQuantity = proQuantity;
    }

    public Integer getProIncome() {
        return proIncome;
    }

    public void setProIncome(Integer proIncome) {
        this.proIncome = proIncome;
    }

    public Date getProPurchaseTime() {
        return proPurchaseTime;
    }

    public void setProPurchaseTime(Date proPurchaseTime) {
        this.proPurchaseTime = proPurchaseTime;
    }
}
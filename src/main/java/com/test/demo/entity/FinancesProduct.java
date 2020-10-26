package com.test.demo.entity;

public class FinancesProduct {
    private Integer pId;

    private String pName;

    private Integer pAmount;

    private Integer pYear;

    private byte[] pDescription;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpAmount() {
        return pAmount;
    }

    public void setpAmount(Integer pAmount) {
        this.pAmount = pAmount;
    }

    public Integer getpYear() {
        return pYear;
    }

    public void setpYear(Integer pYear) {
        this.pYear = pYear;
    }

    public byte[] getpDescription() {
        return pDescription;
    }

    public void setpDescription(byte[] pDescription) {
        this.pDescription = pDescription;
    }
}
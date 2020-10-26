package com.test.demo.entity;

public class Fund {
    private Integer fId;

    private String fName;

    private String fType;

    private Integer fAmount;

    private String riskLevel;

    private Integer fManager;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public Integer getfAmount() {
        return fAmount;
    }

    public void setfAmount(Integer fAmount) {
        this.fAmount = fAmount;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    public Integer getfManager() {
        return fManager;
    }

    public void setfManager(Integer fManager) {
        this.fManager = fManager;
    }
}
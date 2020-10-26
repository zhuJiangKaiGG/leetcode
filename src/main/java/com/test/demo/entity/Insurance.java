package com.test.demo.entity;

public class Insurance {
    private Integer iId;

    private String iName;

    private Integer iAmount;

    private String iPerson;

    private Integer iYear;

    private String iProject;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName == null ? null : iName.trim();
    }

    public Integer getiAmount() {
        return iAmount;
    }

    public void setiAmount(Integer iAmount) {
        this.iAmount = iAmount;
    }

    public String getiPerson() {
        return iPerson;
    }

    public void setiPerson(String iPerson) {
        this.iPerson = iPerson == null ? null : iPerson.trim();
    }

    public Integer getiYear() {
        return iYear;
    }

    public void setiYear(Integer iYear) {
        this.iYear = iYear;
    }

    public String getiProject() {
        return iProject;
    }

    public void setiProject(String iProject) {
        this.iProject = iProject == null ? null : iProject.trim();
    }
}
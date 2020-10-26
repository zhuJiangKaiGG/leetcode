package com.test.demo.entity;

public class Client {
    private Integer cId;

    private String cName;

    private String cMail;

    private String cIdCard;

    private String cPhone;

    private String cPassword;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail == null ? null : cMail.trim();
    }

    public String getcIdCard() {
        return cIdCard;
    }

    public void setcIdCard(String cIdCard) {
        this.cIdCard = cIdCard == null ? null : cIdCard.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    @Override
    public String toString() {
        return "Client{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cMail='" + cMail + '\'' +
                ", cIdCard='" + cIdCard + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cPassword='" + cPassword + '\'' +
                '}';
    }
}

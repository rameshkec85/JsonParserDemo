package com.companyname.jsonparserdemo.model;

public class Phone {
    private String mobile;

    private String office;

    private String home;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "ClassPojo [mobile = " + mobile + ", office = " + office + ", home = " + home + "]";
    }
}

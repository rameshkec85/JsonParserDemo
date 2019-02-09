package com.companyname.jsonparserdemo.model;

public class Contacts {
    private String address;

    private String gender;

    private Phone phone;

    private String name;

    private String id;

    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClassPojo [address = " + address + ", gender = " + gender + ", phone = " + phone + ", name = " + name + ", id = " + id + ", email = " + email + "]";
    }
}
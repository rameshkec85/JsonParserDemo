package com.companyname.jsonparserdemo.model;

import java.util.List;

public class HiveResponse {
    private List<Contacts> contacts;

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "ClassPojo [contacts = " + contacts + "]";
    }
}

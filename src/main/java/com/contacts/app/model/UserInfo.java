package com.contacts.app.model;

import com.contacts.app.entity.Contacts;

import java.util.List;

public class UserInfo {
    private Long id;
    private String email;
    private List<Contacts> contacts;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Contacts> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contacts> contacts) {
        this.contacts = contacts;
    }
}

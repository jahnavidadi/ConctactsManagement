package com.contacts.app.model;

public class ContactInfo {

    private Long id;

    private String email;


    private String phoneno;


    private String name;


    public ContactInfo(){

    }
    public ContactInfo(String name, String email, String phoneno){
        this.email = email;
        this.phoneno = phoneno;
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

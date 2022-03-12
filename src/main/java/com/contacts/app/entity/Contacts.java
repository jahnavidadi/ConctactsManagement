package com.contacts.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "Contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneno;

    @Column(nullable = false)
    private String name;


    public Contacts(){

    }
    public Contacts(String name, String email, String phoneno){
        this.email = email;
        this.phoneno = phoneno;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}

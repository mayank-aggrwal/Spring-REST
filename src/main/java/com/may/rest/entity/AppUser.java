package com.may.rest.entity;

import javax.persistence.Entity;

@Entity
public class AppUser extends BaseEntity {

    private String name;

    public AppUser() {
    }

    public AppUser(String name) {
        this.name = name;
    }

    public AppUser(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.may.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id;
    private  final String name;
    private  final String address;
    private  final Boolean working;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                 @JsonProperty("address") String address,
                 @JsonProperty("working") Boolean working) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.working = working;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public Boolean getWorking() {
        return working;
    }
}

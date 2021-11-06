package com.gabrielfeitosa.user.dto;

public class UserCreateDTO {

    private String name;
    private String document;

    public UserCreateDTO(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }
}

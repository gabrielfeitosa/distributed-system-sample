package com.gabrielfeitosa.user.dto;

import org.apache.catalina.User;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String name;
    private DocumentDTO document;

    public static UserDTO build(UserCreateDTO userCreateDTO, DocumentDTO document) {
        var user  = new UserDTO();
        user.id = UUID.randomUUID();
        user.name = userCreateDTO.getName();
        user.document = document;
        return user;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DocumentDTO getDocument() {
        return document;
    }
}

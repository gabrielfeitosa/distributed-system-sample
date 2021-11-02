package com.gabrielfeitosa.user.services;

import com.gabrielfeitosa.user.dto.UserCreateDTO;
import com.gabrielfeitosa.user.dto.UserDTO;
import com.gabrielfeitosa.user.exceptions.InvalidDocumentException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private DocumentService documentService;
    private static Map<UUID, UserDTO> users = new HashMap<>();

    public UserService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public UUID create(UserCreateDTO dto){
        var document = documentService.getDocument(dto.getDocument());
        if(document.isValid()){
            var user = UserDTO.build(dto, document);
            users.put(user.getId(), user);
            return user.getId();
        }
        throw new InvalidDocumentException(dto.getDocument());
    }

    public List<UserDTO> listAll() {
        return List.copyOf(users.values());
    }
}

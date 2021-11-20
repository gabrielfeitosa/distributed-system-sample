package com.gabrielfeitosa.user.services;

import com.gabrielfeitosa.user.dto.UserCreateDTO;
import com.gabrielfeitosa.user.dto.UserDTO;
import com.gabrielfeitosa.user.exceptions.InvalidDocumentException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private DocumentService documentService;
    private UserNotification userNotification;
    private static Map<UUID, UserDTO> users = new HashMap<>();

    public UserService(DocumentService documentService, UserNotification userNotification) {
        this.documentService = documentService;
        this.userNotification = userNotification;
    }

    public UUID create(UserCreateDTO dto) {
        var document = documentService.getDocument(dto.getDocument());
        if (document.isValid()) {
            var user = UserDTO.build(dto, document);
            users.put(user.getId(), user);
            userNotification.publishNewUser(user);
            return user.getId();
        }
        throw new InvalidDocumentException(dto.getDocument());
    }

    public List<UserDTO> listAll() {
        return List.copyOf(users.values());
    }
}

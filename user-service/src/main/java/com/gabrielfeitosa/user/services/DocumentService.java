package com.gabrielfeitosa.user.services;

import com.gabrielfeitosa.user.clients.DocumentClient;
import com.gabrielfeitosa.user.dto.DocumentDTO;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private DocumentClient documentClient;

    public DocumentService(DocumentClient documentClient) {
        this.documentClient = documentClient;
    }

    public DocumentDTO getDocument(String document) {
        return documentClient.getDocument(document);
    }
}

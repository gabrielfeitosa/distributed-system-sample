package com.gabrielfeitosa.user.exceptions;

public class DocumentNotFoundException extends RuntimeException {
    public DocumentNotFoundException(String document) {
        super(String.format("Document %s not found", document));
    }
}

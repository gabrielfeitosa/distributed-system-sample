package com.gabrielfeitosa.user.exceptions;

public class InvalidDocumentException extends RuntimeException {
    public InvalidDocumentException(String document) {
        super(String.format("Document %s is invalid", document));
    }
}

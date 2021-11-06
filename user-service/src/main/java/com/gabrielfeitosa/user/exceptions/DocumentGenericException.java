package com.gabrielfeitosa.user.exceptions;

public class DocumentGenericException extends RuntimeException {
    public DocumentGenericException(int status, String reason) {
        super(String.format("Status Code: %s. %s", status, reason));
    }
}

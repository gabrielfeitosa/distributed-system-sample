package com.gabrielfeitosa.user.decoder;

import com.gabrielfeitosa.user.exceptions.DocumentGenericException;
import com.gabrielfeitosa.user.exceptions.DocumentNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class DocumentErrorDecode implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 404:
                return new DocumentNotFoundException("");
            default:
                return new DocumentGenericException(response.status(), response.reason());
        }
    }
}

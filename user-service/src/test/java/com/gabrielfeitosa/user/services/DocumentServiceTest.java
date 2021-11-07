package com.gabrielfeitosa.user.services;

import com.gabrielfeitosa.user.exceptions.DocumentGenericException;
import com.gabrielfeitosa.user.exceptions.DocumentNotFoundException;
import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "document.url=http://localhost:${wiremock.server.port}/document")
@AutoConfigureWireMock(port = 0)
class DocumentServiceTest {

    @Autowired
    private DocumentService documentService;

    @Test
    public void validDocument() {
        var document = documentService.getDocument("valid");
        assertEquals(document.getDocument(), "valid");
        assertEquals(document.getType(), "type1");
        assertTrue(document.isValid());
    }

    @Test
    public void invalidDocument() {
        var document = documentService.getDocument("invalid");
        assertEquals(document.getDocument(), "invalid");
        assertNull(document.getType());
        assertFalse(document.isValid());
    }

    @Test
    public void documentNotFound() {
        assertThrows(DocumentNotFoundException.class, () -> documentService.getDocument("notfound"));
    }

    @Test
    public void documentTimeout() {
        assertThrows(RetryableException.class, () -> documentService.getDocument("delay"));
    }

    @Test
    public void documentServerError() {
        assertThrows(DocumentGenericException.class, () -> documentService.getDocument("error"));
    }
}
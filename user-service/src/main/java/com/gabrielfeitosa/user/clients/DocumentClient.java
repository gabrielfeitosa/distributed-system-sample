package com.gabrielfeitosa.user.clients;

import com.gabrielfeitosa.user.dto.DocumentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "document", url = "${feign.client.config.document.url}")
public interface DocumentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    DocumentDTO getDocument(@PathVariable("id") String document);
}

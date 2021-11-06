package com.gabrielfeitosa.user.controller;

import com.gabrielfeitosa.user.dto.DocumentDTO;
import com.gabrielfeitosa.user.dto.UserCreateDTO;
import com.gabrielfeitosa.user.dto.UserDTO;
import com.gabrielfeitosa.user.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    void listAll() throws Exception {
        when(userService.listAll()).thenReturn(List.of(UserDTO.build(new UserCreateDTO("test", "doc"), new DocumentDTO())))
        ;
        mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.length()").value(1))
                .andExpect(jsonPath("$.data[*].name", containsInAnyOrder("test")));
    }

    @Test
    void shouldCreateUser() throws Exception {
        var json = "{\"name\": \"test\", \"document\":\"abc123\"}";
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
    }
}
package com.example.ecommerce_backend.controller;

import com.example.ecommerce_backend.dto.request.CartRequest;
import com.example.ecommerce_backend.dto.response.CartResponse;
import com.example.ecommerce_backend.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;
    private CartResponse cartResponse;
    private CartRequest cartRequest;

    @BeforeEach
    void initDatat(){

    }

//    @Test
//    @WithMockUser(username="admin")
//    void createValidImage() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//        String content = objectMapper.writeValueAsString(cartRequest);
//        Mockito.when(cartService.addCartItem(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(cartResponse);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .post("/user/{userId}/cart/add/{productId}")
//                        .param("productId", "00000000-3838-3137-0000-000000000000")
//                        .param("userId", "00000000-3838-3137-0000-000000000000")
//                        .content(content)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("code").value("1000"))
//                .andExpect(MockMvcResultMatchers.jsonPath("result.pathImage").value("/woman/dress/1/123.jpg"))
//                .andExpect(MockMvcResultMatchers.jsonPath("result.pathId").value("/woman/dress/1")
//                );
//    }
}

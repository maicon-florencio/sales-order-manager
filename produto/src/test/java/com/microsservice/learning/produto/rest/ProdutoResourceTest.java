package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class ProdutoResourceTest {

    private final String API ="/api/products";
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProdutoService produtoService;

    private  ProdutoBuilder produtoBuilder;
    @BeforeEach
    public void setUp(){
        produtoBuilder = new ProdutoBuilder();
    }

    @Test
    @DisplayName("buscar produto por ID")
    public void findProductsById() throws Exception {

        var pDTO = produtoBuilder.criarProdutoDTO(1L);
     BDDMockito.given(produtoService.getById(1L)).willReturn(pDTO);

     var request = MockMvcRequestBuilders.get(API.concat("/" + 1L)).accept(MediaType.APPLICATION_JSON);

     mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
             .andExpect(MockMvcResultMatchers.jsonPath("id").value(pDTO.getId()))
             .andExpect(jsonPath("name").value(pDTO.getName()))
             .andExpect(jsonPath("desc").value(pDTO.getDesc()))
             .andExpect(jsonPath("price").value(pDTO.getPrice()))
             .andExpect(jsonPath("quantity").value(pDTO.getQuantity()));


    }




}

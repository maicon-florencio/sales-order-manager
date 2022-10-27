package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.service.ProdutoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoResourceIntTest {
    private final String API ="/api/products";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProdutoBuilder produtoBuilder;
    @MockBean
    private ProdutoService produtoService;

    @Test
    void buscarProdutos() throws Exception {
        var prod = produtoBuilder.criarProdutoDTO(1l);

        Mockito.when(produtoService.getById(1L)).thenReturn(prod);

        var request = MockMvcRequestBuilders
                .get(API.concat("/" + 1L)).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(prod.getId()))
                .andExpect(jsonPath("name").value(prod.getName()))
                .andExpect(jsonPath("price").value(prod.getPrice()));

        Assertions.assertEquals("Potato Chips", prod.getName());
    }
}

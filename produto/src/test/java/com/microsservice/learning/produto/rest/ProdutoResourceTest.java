package com.microsservice.learning.produto.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.service.mapper.ProdutoMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoResourceTest {

    final String API =  "/api/produtcs";
    @Autowired
    private ProdutoBuilder produtoBuilder;
    @Autowired
    MockMvc mock;


    private ProdutoMapper mapper;

    @Test
    public void saveNovoProdutoSucesso() throws Exception {
    var pDTO = produtoBuilder.criarProdutoNovo();
    String jsonTest = new ObjectMapper().writeValueAsString(pDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(API)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonTest);

         mock.perform(request).andExpect(MockMvcResultMatchers.status().isCreated())
                 .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                 .andExpect(MockMvcResultMatchers.jsonPath("nome").value(pDTO.getName()));
    }


}

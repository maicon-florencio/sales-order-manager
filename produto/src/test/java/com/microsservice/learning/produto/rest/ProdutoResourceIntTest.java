package com.microsservice.learning.produto.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

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
    void buscarProdutoPorId() throws Exception {
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

        Assertions.assertEquals("Baby beef", prod.getName());
    }

    @Test
    void buscarProdutos() throws Exception {
        var prod = produtoBuilder.criarProdutoDTO(1L);
        List<ProdutoDTO> pDTOs = Arrays.asList(prod);
        Mockito.when(produtoService.listAll()).thenReturn(pDTOs);

        var request = MockMvcRequestBuilders
                .get(API).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


       Assertions.assertTrue(pDTOs.size() > 0);
       Assertions.assertTrue(pDTOs.get(0).getName().equals(prod.getName()));

    }

    @Test
    void cadastrarUmProduto() throws Exception {
        var pdto= produtoBuilder.criarProdutoDTONovo();

        var pdtCriado = produtoBuilder.criarProdutoDTO(1L);

        Mockito.when(produtoService.save(Mockito.any())).thenReturn(pdtCriado);

        var request = MockMvcRequestBuilders
                .post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pdto) )
                .accept(MediaType.APPLICATION_JSON);


        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("name").value(pdtCriado.getName()))
                .andExpect(jsonPath("price").value(pdtCriado.getPrice()));

        Assertions.assertTrue(pdtCriado.getName().equals(pdto.getName()));

    }


}

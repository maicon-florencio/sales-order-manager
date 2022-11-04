package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.builder.EstoqueBuilder;
import com.microsservice.learning.produto.dominio.Estoque;
import com.microsservice.learning.produto.service.EstoqueService;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EstoqueResourceTestInt {

    private  final String API = "/api/estoque";

    @Autowired
    private EstoqueBuilder estoqueBuilder;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EstoqueService estoqueService;


    @Test
    public  void buscarEstoquePorId() throws Exception {
        var dto = estoqueBuilder.novoEstoqueDTOComProduto();
        dto.setId(1L);

        Mockito.when(estoqueService.getById(1L)).thenReturn(dto);


        var request = MockMvcRequestBuilders
                .get(API.concat("/" + 1L)).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(dto.getId()))
                .andExpect(jsonPath("quantidadeProdutoEstoque").value(dto.getQuantidadeProdutoEstoque()))
                .andExpect(jsonPath("statusPermissaoVenda").value(dto.getStatusPermissaoVenda()));

        Assertions.assertEquals(1L, dto.getId());
    }

    @Test
    public  void buscarEstoqueTodos() throws Exception {
        var dto = Collections.singletonList(estoqueBuilder.novoEstoqueDTOComProduto());

        Mockito.when(estoqueService.listAll()).thenReturn(dto);


        var request = MockMvcRequestBuilders
                .get(API).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());

        Assertions.assertTrue(dto.size() > 0);
    }

}

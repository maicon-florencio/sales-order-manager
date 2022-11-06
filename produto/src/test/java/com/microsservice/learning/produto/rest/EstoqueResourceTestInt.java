package com.microsservice.learning.produto.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.learning.produto.builder.EstoqueBuilder;
import com.microsservice.learning.produto.dominio.enun.ProdutoStatusVendaEnum;
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

import java.util.Collections;

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

    @Test
    public void deletarUmEstoqueCadastrado() throws Exception {

        var request = MockMvcRequestBuilders
                .delete(API.concat("/"+1)).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    public void cadastrarUmEstoque() throws Exception {

        var eDto = estoqueBuilder.novoEstoqueDTOComProdutoPorId(1L);


        Mockito.when(estoqueService.save(Mockito.any())).thenReturn(eDto);



        var request = MockMvcRequestBuilders
                .post(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(eDto) )
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("quantidadeProdutoEstoque").value(eDto.getQuantidadeProdutoEstoque()))
                .andExpect(jsonPath("statusPermissaoVenda").value(eDto.getStatusPermissaoVenda()));

        Assertions.assertTrue(ProdutoStatusVendaEnum.ATIVO.getStatus().equals(eDto.getStatusPermissaoVenda()));

    }
    @Test
    public void atualizarUmEstoqueExistente() throws Exception {

        var eDto = estoqueBuilder.novoEstoqueDTOComProdutoPorId(1L);

        var eDtoUpdated = estoqueBuilder.novoEstoqueDTOComProdutoPorId(1L);
        eDtoUpdated.setQuantidadeProdutoEstoque(10);

        Mockito.when(estoqueService.udpate(Mockito.any(EstoqueDTO.class))).thenReturn(eDtoUpdated);


        var request = MockMvcRequestBuilders
                .put(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(eDtoUpdated) )
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("quantidadeProdutoEstoque").value(eDtoUpdated.getQuantidadeProdutoEstoque()))
                .andExpect(jsonPath("statusPermissaoVenda").value(eDtoUpdated.getStatusPermissaoVenda()));

        Assertions.assertEquals(10, eDtoUpdated.getQuantidadeProdutoEstoque());

    }




}

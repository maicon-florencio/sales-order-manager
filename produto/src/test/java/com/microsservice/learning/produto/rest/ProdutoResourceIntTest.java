package com.microsservice.learning.produto.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
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
        var prod = produtoBuilder.criarProdutoDTO(1L);

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
    @DisplayName("Teste para buscar um produto com ID especifico")
    void buscarProdutos() throws Exception {
        var prod = produtoBuilder.criarProdutoDTO(1L);
        List<ProdutoDTO> pDTOs = Collections.singletonList(prod);
        Mockito.when(produtoService.listAll()).thenReturn(pDTOs);

        var request = MockMvcRequestBuilders
                .get(API).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


       Assertions.assertNotNull(pDTOs);
        Assertions.assertEquals(pDTOs.get(0).getName(), prod.getName());

    }

    @Test
    @DisplayName("Buscando produtos com limite de paginacao")
    void buscarProdutosPorPaginacao() throws Exception {
        var prod = produtoBuilder.criarProdutoDTO(1L);
        List<ProdutoDTO> pDTOs = Collections.singletonList(prod);

        Mockito.when(produtoService.listPagina(Mockito.any(Pageable.class)))
                .thenReturn(new PageImpl<>(pDTOs, PageRequest.of(0,100),1));

        var request = MockMvcRequestBuilders
                .get(API.concat("/busca-paginada?page=0&size=100")).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("pageable.pageSize").value(100))
                .andExpect(jsonPath("pageable.pageNumber").value(0));


        Assertions.assertNotNull(pDTOs);
        Assertions.assertEquals(pDTOs.get(0).getName(), prod.getName());

    }

    @Test
    @DisplayName("Teste para cadastrar um novo produto")
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

        Assertions.assertEquals(pdtCriado.getName(), pdto.getName());

    }

    @Test
    void atualizarProduto() throws Exception {

        var pdtCriado = produtoBuilder.criarProdutoDTO(1L);

        var pDTOu = produtoBuilder.criarProdutoDTO(1L);

        pDTOu.setDesc("Nova direcao");

        Mockito.when(produtoService.save(Mockito.any(ProdutoDTO.class))).thenReturn(pDTOu);

        var request = MockMvcRequestBuilders
                .put(API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(pDTOu) )
                .accept(MediaType.APPLICATION_JSON);


        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("name").value(pdtCriado.getName()))
                .andExpect(jsonPath("desc").value("Nova direcao"));



    }


}

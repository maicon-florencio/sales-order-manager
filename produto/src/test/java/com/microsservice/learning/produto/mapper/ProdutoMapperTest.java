package com.microsservice.learning.produto.mapper;

import com.microsservice.learning.produto.builder.ProdutoBuilder;
import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import com.microsservice.learning.produto.service.mapper.ProdutoMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoMapperTest {
    @Autowired
    private ProdutoMapper mapper;
    @Autowired
    private ProdutoBuilder produtoBuilder;


    @Test
    public void conversaoEntityToDTO(){
        Produto p =produtoBuilder.criarProduto(1L);

        ProdutoDTO pDTO = mapper.toDTO(p);

        Assertions.assertEquals(1L,pDTO.getId());
        Assertions.assertEquals("Potato Chips",pDTO.getName());
    }
    @Test
    public void conversaoDtotoEntity(){
        ProdutoDTO pDTO =produtoBuilder.criarProdutoDTO(1L);

        Produto p = mapper.toEntity(pDTO);

        Assertions.assertEquals(1L,pDTO.getId());
        Assertions.assertEquals("Potato Chips",pDTO.getName());
    }



}

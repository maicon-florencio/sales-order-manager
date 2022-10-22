package com.microsservice.learning.produto.mapper;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import com.microsservice.learning.produto.service.mapper.DozerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoDozerMapperTests {


    @Test
    public void conversaoEntityToDTODozerMappe(){

        ProdutoDTO pDTO = DozerMapper.parseOject(criarProduto(2L),ProdutoDTO.class);
        Assertions.assertEquals(2L,pDTO.getId());
        Assertions.assertEquals("Chicken french",pDTO.getName());
    }
    @Test
    public void conversaoDtotoEntityDozerMappe(){

        Produto p = DozerMapper.parseOject(criarProdutoDTO(1L), Produto.class);

        Assertions.assertEquals(1L,p.getId());
        Assertions.assertEquals("Potato Chips",p.getName());
    }

    public Produto criarProduto(Long id){
        return Produto.builder()
                .id(id)
                .name("Chicken french")
                .desc("250g frango com molho barbecue")
                .quantity(1)
                .price(17.15)
                .build();
    }

    public ProdutoDTO criarProdutoDTO(Long id){
        return ProdutoDTO.builder()
                .id(id)
                .name("Potato Chips")
                .desc("150g potato with bacon and cheddar")
                .quantity(1)
                .price(17.15)
                .build();
    }
}

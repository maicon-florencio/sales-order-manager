package com.microsservice.learning.produto.builder;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBuilder {

    public Produto criarProduto(Long id){
        return Produto.builder()
                .id(id)
                .name("Potato Chips")
                .desc("150g potato with bacon and cheddar")
                .price(17.15)
                .build();
    }
    public Produto criarProdutoNovo(){
        return Produto.builder()
                .name("Potato Chips")
                .desc("150g potato with bacon and cheddar")
                .price(17.15)
                .build();
    }
    public ProdutoDTO criarProdutoDTONovo(){
        return ProdutoDTO.builder()
                .name("Baby beef")
                .desc("250g angus beefs com bacon")
                .price(69.90)
                .build();
    }

    public ProdutoDTO criarProdutoDTO(Long id){
        return ProdutoDTO.builder()
                .id(id)
                .name("Baby beef")
                .desc("250g angus beefs com bacon")
                .price(69.90)
                .build();
    }

}

package com.microsservice.learning.produto.builder;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.dominio.enun.StatusProdutoEnum;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProdutoBuilder {

    public Produto criarProduto(Long id){
        return Produto.builder()
                .id(id)
                .name("Potato Chips")
                .price(17.15)
                .statusP(StatusProdutoEnum.APROVADO.getNomeTipo())
                .build();
    }
    public Produto criarProdutoNovo(){
        return Produto.builder()
                .name("Potato Chips")
                .price(17.15)
                .statusP(StatusProdutoEnum.APROVADO.getNomeTipo())
                .build();
    }
    public ProdutoDTO criarProdutoDTONovo(){
        return ProdutoDTO.builder()
                .name("Baby beef")
                .price(69.90)
                .statusProduto(StatusProdutoEnum.APROVADO.getNomeTipo())
                .build();
    }

    public ProdutoDTO criarProdutoDTO(Long id){
        return ProdutoDTO.builder()
                .id(id)
                .name("Baby beef")
                .price(69.90)
                .statusProduto(StatusProdutoEnum.APROVADO.getNomeTipo())
                .build();
    }

}

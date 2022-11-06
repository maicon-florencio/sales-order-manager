package com.microsservice.learning.produto.builder;

import com.microsservice.learning.produto.dominio.Estoque;
import com.microsservice.learning.produto.dominio.enun.ProdutoStatusVendaEnum;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EstoqueBuilder {
    @Autowired
    private ProdutoBuilder produtoBuilder;

    public Estoque novoEstoqueComProduto(){
     return Estoque.builder()
             .quantidadeProdutoEstoque(200)
             .produtos(produtoBuilder.listaProdutoNew())
             .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus()).build();
    }

    public Estoque novoEstoqueSemProduto(){
        return Estoque.builder()
                .quantidadeProdutoEstoque(200)
                .produtos(null)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus()).build();
    }

    public EstoqueDTO novoEstoqueDTOComProduto(){
        return EstoqueDTO.builder()
                .quantidadeProdutoEstoque(157)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtosOrder(produtoBuilder.listaProdutoNew())
                .build();
    }

    public EstoqueDTO novoEstoqueDTOComProdutoPorId(Long id){
        return EstoqueDTO.builder()
                .id(id)
                .quantidadeProdutoEstoque(157)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtosOrder(produtoBuilder.listaProdutoNew())
                .build();
    }

    public List<EstoqueDTO> listaEstoqueDTOs(){
      var dto1=  EstoqueDTO.builder()
              .id(1L)
                .quantidadeProdutoEstoque(157)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtosOrder(produtoBuilder.listaProdutoNew())
                .build();

        var dto2=  EstoqueDTO.builder()
                .id(2L)
                .quantidadeProdutoEstoque(120)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtosOrder(produtoBuilder.listaProdutoNew())
                .build();

        var dto3=  EstoqueDTO.builder()
                .id(3L)
                .quantidadeProdutoEstoque(143)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtosOrder(produtoBuilder.listaProdutoNew())
                .build();


        return Arrays.asList(dto1,dto2,dto3);
    }


    public List<Estoque> listaEstoque(){
        var dto1=  Estoque.builder()
                .id(1L)
                .quantidadeProdutoEstoque(157)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtos(produtoBuilder.listaProdutoNew())
                .build();

        var dto2=  Estoque.builder()
                .id(2L)
                .quantidadeProdutoEstoque(120)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtos(produtoBuilder.listaProdutoNew())
                .build();

        var dto3=  Estoque.builder()
                .id(3L)
                .quantidadeProdutoEstoque(143)
                .statusPermissaoVenda(ProdutoStatusVendaEnum.ATIVO.getStatus())
                .produtos(produtoBuilder.listaProdutoNew())
                .build();


        return Arrays.asList(dto1,dto2,dto3);
    }



}

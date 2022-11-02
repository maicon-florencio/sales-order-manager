package com.microsservice.learning.produto.mapper;

import com.microsservice.learning.produto.builder.EstoqueBuilder;
import com.microsservice.learning.produto.dominio.Estoque;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import com.microsservice.learning.produto.service.mapper.EstoqueMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EstoqueMapperTest {

    @Autowired
    private EstoqueBuilder estoqueBuilder;
    @Autowired
    private EstoqueMapper mapper;
    @Test
    public void converterEntityToDTO(){
        var entity = mapper.dtoToEntity(estoqueBuilder.novoEstoqueDTOComProduto());
        var dto = estoqueBuilder.novoEstoqueDTOComProduto();

        Assertions.assertEquals(entity.getQuantidadeProdutoEstoque(),dto.getQuantidadeProdutoEstoque());
        Assertions.assertEquals(entity.getProdutos(),dto.getProdutosOrder());

    }
    @Test
    public void converteDTOtoEntity(){

        var dto = mapper.entityToDTO(estoqueBuilder.novoEstoqueComProduto());
        var entity = estoqueBuilder.novoEstoqueComProduto();

        Assertions.assertEquals(dto.getQuantidadeProdutoEstoque(),entity.getQuantidadeProdutoEstoque());
        Assertions.assertEquals(dto.getProdutosOrder(),entity.getProdutos());


    }
    @Test
    public void converteListEntitiesTOListDTOs(){

        var entities = mapper.toListEntities(estoqueBuilder.listaEstoqueDTOs());
        Assertions.assertTrue(entities instanceof List<Estoque>);
        Assertions.assertTrue(entities.get(0).getProdutos().size() > 2);

    }
    @Test
    public void converteLisDTosTOEntitys(){

        var dtos = mapper.toListDTOs(estoqueBuilder.listaEstoque());
        Assertions.assertTrue(dtos instanceof List<EstoqueDTO>);
        Assertions.assertTrue(dtos.get(0).getProdutosOrder().size() > 2);

    }


}

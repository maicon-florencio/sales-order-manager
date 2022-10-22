package com.microsservice.learning.produto.service.mapper;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "entity.desc",target = "desc")
    ProdutoDTO toDTO(Produto entity);

    List<ProdutoDTO> toDtos(List<Produto> produto);

    @InheritInverseConfiguration
    Produto toEntity(ProdutoDTO pDto);

    List<Produto> toEntitys(List<ProdutoDTO> produtoDTOs);
}

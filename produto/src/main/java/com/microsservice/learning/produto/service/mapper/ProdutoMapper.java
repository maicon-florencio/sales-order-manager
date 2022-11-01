package com.microsservice.learning.produto.service.mapper;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.xml.transform.Source;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring",uses = {})
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(source = "entity.name",target = "name")
    @Mapping(source = "entity.statusP",target = "statusProduto")
    ProdutoDTO toDTO(Produto entity);

    List<ProdutoDTO> toDtos(List<Produto> produto);

    @InheritInverseConfiguration
    Produto toEntity(ProdutoDTO pDto);

    List<Produto> toEntitys(List<ProdutoDTO> produtoDTOs);

}

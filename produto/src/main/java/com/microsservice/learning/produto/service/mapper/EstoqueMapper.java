package com.microsservice.learning.produto.service.mapper;

import com.microsservice.learning.produto.dominio.Estoque;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ProdutoMapper.class})
public interface EstoqueMapper {

    EstoqueMapper INSTANCE = Mappers.getMapper(EstoqueMapper.class);


    @Mapping(source = "entity.quantidadeProdutoEstoque",target = "quantidadeProdutoEstoque")
    @Mapping(source = "entity.statusPermissaoVenda",target = "statusPermissaoVenda")
    @Mapping(source= "entity.produtos",target = "produtosOrder")
    EstoqueDTO entityToDTO(Estoque entity);

    List<EstoqueDTO> toListDTOs(List<Estoque> entities);

    @InheritInverseConfiguration
    Estoque dtoToEntity(EstoqueDTO dto);

    List<Estoque> toListEntities(List<EstoqueDTO> listDTOs);

}

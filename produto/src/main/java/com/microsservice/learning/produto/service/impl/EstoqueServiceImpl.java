package com.microsservice.learning.produto.service.impl;

import com.microsservice.learning.produto.exception.BussinessException;
import com.microsservice.learning.produto.service.EstoqueService;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import com.microsservice.learning.produto.service.mapper.EstoqueMapper;
import com.microsservice.learning.produto.service.repository.EstoqueRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;

    private final EstoqueMapper estoqueMapper;

    public EstoqueServiceImpl(EstoqueRepository estoqueRepository, EstoqueMapper estoqueMapper) {
        this.estoqueRepository = estoqueRepository;
        this.estoqueMapper = estoqueMapper;
    }

    @Override
    public EstoqueDTO save(EstoqueDTO dto) {
        if(Objects.isNull(dto))
            throw new BussinessException("resource is not found");
        var responseDTO = estoqueRepository.save(estoqueMapper.dtoToEntity(dto));
        return estoqueMapper.entityToDTO(responseDTO);
    }

    @Override
    public EstoqueDTO udpate(EstoqueDTO dto) {
        if(Boolean.FALSE.equals(existEstoque(dto.getId()))) throw new BussinessException("Resource not found");

        var estoque = estoqueRepository.save(estoqueMapper.dtoToEntity(dto));
        return estoqueMapper.entityToDTO(estoque);
    }

    @Override
    public EstoqueDTO getById(Long id) {
        var estEntity= estoqueMapper.entityToDTO(estoqueRepository.getReferenceById(Objects.requireNonNull(id)));
        if(Objects.isNull(estEntity)) throw new BussinessException("Resource not found");
        return estEntity;
    }

    @Override
    public void delete(Long id) {
        var dtoFind = getById(id);
        if (Objects.isNull(dtoFind)) throw  new BussinessException("Estoque não encontrado");
        estoqueRepository.delete(estoqueMapper.dtoToEntity(dtoFind));
    }

    @Override
    public List<EstoqueDTO> listAll() {
        return estoqueMapper.toListDTOs(estoqueRepository.findAll());
    }

    private Boolean existEstoque(Long id){
        if(Objects.isNull(id))
            throw new BussinessException("O id de busca é null");
        return estoqueRepository.existsById(id);
    }
}

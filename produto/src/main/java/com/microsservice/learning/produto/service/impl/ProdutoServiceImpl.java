package com.microsservice.learning.produto.service.impl;

import com.microsservice.learning.produto.dominio.Estoque;
import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.exception.BussinessException;
import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import com.microsservice.learning.produto.service.mapper.ProdutoMapper;
import com.microsservice.learning.produto.service.repository.ProdutoRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRespository produtoDAO;

    private final ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(ProdutoRespository produtoDAO, ProdutoMapper produtoMapper) {
        this.produtoDAO = produtoDAO;
        this.produtoMapper = produtoMapper;
    }


    @Override
    public ProdutoDTO save(ProdutoDTO dto) {
        if(existsProduto(produtoMapper.toEntity(dto)))
            throw new BussinessException("Exists Produto");
        dto.setEstoque(new Estoque());
        var produto = produtoDAO.save(produtoMapper.toEntity(dto));

        return produtoMapper.toDTO(produto);
    }

    @Override
    public ProdutoDTO udpate(ProdutoDTO dto) {
        if(dto ==null)
            throw  new IllegalArgumentException("Produto não pode ser null");
        var produto = produtoDAO.save(produtoMapper.toEntity(dto));
        return produtoMapper.toDTO(produto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProdutoDTO getById(Long id) {
        var dtoEncontrado = produtoDAO.getReferenceById(Objects.requireNonNull(id));
        if(dtoEncontrado == null) throw new IllegalArgumentException("Produto não encontrado");
        return produtoMapper.toDTO(dtoEncontrado);

    }

    @Override
    public void delete(Long id) {
        var pDto = getById(Objects.requireNonNull(id));
        if(Objects.isNull(pDto))
          throw new BussinessException(" Não exists Produto");

        produtoDAO.delete(produtoMapper.toEntity(pDto));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProdutoDTO> listAll() {
        return produtoMapper.toDtos(produtoDAO.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProdutoDTO> listPagina(Pageable paginacao) {
        return produtoDAO.findAll(paginacao).map(produtoMapper::toDTO);
    }

    private boolean existsProduto(Produto produto){
        return (produtoDAO.existsById(produto.getId()))? Boolean.TRUE : Boolean.FALSE;
    }


}

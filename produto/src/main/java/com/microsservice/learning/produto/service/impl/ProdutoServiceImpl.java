package com.microsservice.learning.produto.service.impl;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.exception.BussinessException;
import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import com.microsservice.learning.produto.service.mapper.ProdutoMapper;
import com.microsservice.learning.produto.service.repository.ProdutoRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRespository produtoDAO;
    private ProdutoMapper produtoMapper;

    public ProdutoServiceImpl(ProdutoRespository produtoDAO) {
        this.produtoDAO = produtoDAO;
    }


    @Override
    public ProdutoDTO save(ProdutoDTO dto) {
        if(existsProduto(produtoMapper.toEntity(dto)))
            throw new BussinessException("Exists Produto");
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
    public ProdutoDTO getById(Long id) {
        return produtoMapper.toDTO(produtoDAO.getById(id));
    }

    @Override
    public void delete(Long id) {
        var pDto = getById(Objects.requireNonNull(id));
        if(Objects.isNull(pDto))
          throw new BussinessException(" Não exists Produto");

        produtoDAO.delete(produtoMapper.toEntity(pDto));
    }

    @Override
    public List<ProdutoDTO> listAll() {
        return produtoMapper.toDtos(produtoDAO.findAll());
    }

    private boolean existsProduto(Produto produto){
        return (produtoDAO.existsById(produto.getId()))? Boolean.TRUE : Boolean.FALSE;
    }


}

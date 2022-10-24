package com.microsservice.learning.produto.service;

import com.microsservice.learning.produto.dominio.Produto;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoDTO save (ProdutoDTO dto);
    ProdutoDTO udpate( ProdutoDTO dto);
    ProdutoDTO getById(Long id);
    void delete(Long id);

    List<ProdutoDTO> listAll();

}

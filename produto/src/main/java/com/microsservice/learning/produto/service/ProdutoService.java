package com.microsservice.learning.produto.service;

import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO save (ProdutoDTO dto);
    ProdutoDTO udpate( ProdutoDTO dto);
    ProdutoDTO getById(Long id);
    void delete(Long id);

    List<ProdutoDTO> listAll();

    Page<ProdutoDTO> listPagina(Pageable paginacao);

}

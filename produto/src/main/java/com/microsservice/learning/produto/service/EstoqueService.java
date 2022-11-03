package com.microsservice.learning.produto.service;

import com.microsservice.learning.produto.service.dto.EstoqueDTO;

import java.util.List;

public interface EstoqueService {

    EstoqueDTO save (EstoqueDTO dto);
    EstoqueDTO udpate( EstoqueDTO dto);
    EstoqueDTO getById(Long id);
    void delete(Long id);
    List<EstoqueDTO> listAll();

}

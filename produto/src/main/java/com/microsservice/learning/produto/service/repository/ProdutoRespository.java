package com.microsservice.learning.produto.service.repository;

import com.microsservice.learning.produto.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Long> {

}

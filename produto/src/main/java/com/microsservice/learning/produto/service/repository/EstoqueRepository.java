package com.microsservice.learning.produto.service.repository;

import com.microsservice.learning.produto.dominio.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}

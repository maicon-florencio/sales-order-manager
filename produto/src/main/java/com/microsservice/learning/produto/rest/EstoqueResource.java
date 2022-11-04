package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.service.EstoqueService;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueResource {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDTO> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(estoqueService.getById(id));
    }

    @GetMapping()
    public ResponseEntity<List<EstoqueDTO>> buscarAll(){
        return ResponseEntity.ok(estoqueService.listAll());
    }

}

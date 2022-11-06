package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.service.EstoqueService;
import com.microsservice.learning.produto.service.dto.EstoqueDTO;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<EstoqueDTO> delete(@PathVariable("id") Long id){
        estoqueService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<EstoqueDTO> save(@RequestBody  EstoqueDTO dto){
        return new ResponseEntity<>(estoqueService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EstoqueDTO> atualizar(@RequestBody  EstoqueDTO dto){
        return new ResponseEntity<>(estoqueService.udpate(dto), HttpStatus.OK);
    }

}

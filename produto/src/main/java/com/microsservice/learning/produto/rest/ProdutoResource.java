package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.service.ProdutoService;
import com.microsservice.learning.produto.service.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProdutoResource {

    @Autowired
    private  ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO pDTO){
        return new ResponseEntity<>(produtoService.save(pDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO pDTO){
        return ResponseEntity.ok(produtoService.save(pDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoId(@PathVariable("id") Long id){
        return ResponseEntity.ok(produtoService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
       produtoService.delete(id);
    }
    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos(){
        return ResponseEntity.ok(produtoService.listAll());
    }




}

package com.microsservice.learning.produto.rest;

import com.microsservice.learning.produto.builder.EstoqueBuilder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class EstoqueResourceTestInt {

    private  final String API = "/api/estoque";

    private EstoqueBuilder estoqueBuilder;

}

package com.microsservice.learning.produto.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class ProdutoDTO implements Serializable {

    private Long id;
    private String name;
    private String desc;
    private double price;
    private String statusProduto;
}

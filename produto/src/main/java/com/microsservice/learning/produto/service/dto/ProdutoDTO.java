package com.microsservice.learning.produto.service.dto;

import com.microsservice.learning.produto.dominio.Estoque;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

@Getter
@Setter
@Builder
public class ProdutoDTO implements Serializable {

    private Long id;
    private String name;
    private String desc;
    private float price;
    private String statusProduto;
    private Estoque estoque;
    private Calendar dtVencimento;
}

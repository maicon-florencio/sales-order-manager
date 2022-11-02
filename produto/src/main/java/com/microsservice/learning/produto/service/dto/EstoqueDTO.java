package com.microsservice.learning.produto.service.dto;

import com.microsservice.learning.produto.dominio.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO implements Serializable {

    private Long id;
    private Integer quantidadeProdutoEstoque;
    private String statusPermissaoVenda;
    private List<Produto> produtosOrder;
}

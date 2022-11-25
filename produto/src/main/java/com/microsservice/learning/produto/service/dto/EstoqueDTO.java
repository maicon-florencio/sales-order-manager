package com.microsservice.learning.produto.service.dto;

import com.microsservice.learning.produto.dominio.Produto;
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
    private String nomeLocalEstoque;
    private List<Produto> produtosOrder;
}

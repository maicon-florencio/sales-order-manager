package com.microsservice.learning.produto.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estoque")
    private Long id;
    @Column(name = "qt_prod_estoque")
    private Integer quantidadeProdutoEstoque;
    @Column(name = "status_permissao_venda")
    private String statusPermissaoVenda;


    @OneToMany(mappedBy ="estoque", cascade = CascadeType.ALL)
    private List<Produto> produtos;


}

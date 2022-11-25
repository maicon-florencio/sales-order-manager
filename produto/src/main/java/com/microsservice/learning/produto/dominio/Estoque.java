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
@Table(name = "TB_ESTOQUE")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "qt_prod_estoque")
    private Integer quantidadeProdutoEstoque;
    @Column(name = "status_permissao_venda")
    private String statusPermissaoVenda;
    @Column(name = "nm_local_estoque")
    private String nomeLocalEstoque;

    @OneToMany(mappedBy ="estoque")
    private List<Produto> produtos;


}


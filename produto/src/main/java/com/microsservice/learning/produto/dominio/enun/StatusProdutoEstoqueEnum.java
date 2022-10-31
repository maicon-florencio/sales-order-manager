package com.microsservice.learning.produto.dominio.enun;

import java.io.Serializable;

public enum StatusProdutoEstoqueEnum implements Serializable {

    AGUARDANDO_APROVACAO("aguardando aprovacao", 1),
    APROVADO("Aprovado", 2),
    NAO_APROVADO("Nao Aprovado", 3);

    private String nomeTipo;
    private Integer codeTipo;

    StatusProdutoEstoqueEnum(String tipo, Integer code){
        this.nomeTipo= tipo;
        this.codeTipo =code;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public Integer getCodeTipo() {
        return codeTipo;
    }
}

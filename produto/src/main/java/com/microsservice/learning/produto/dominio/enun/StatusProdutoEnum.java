package com.microsservice.learning.produto.dominio.enun;

import java.io.Serializable;

public enum StatusProdutoEnum implements Serializable {

    AGUARDANDO_APROVACAO("AGUARDANDO_APROVACAO", 1),
    APROVADO("APROVADO", 2),
    NAO_APROVADO("NAO_APROVADO", 3),
    PENDENTE("PENDENTE", 4);


    private String nomeTipo;
    private Integer codeTipo;

    StatusProdutoEnum(String tipo, Integer code){
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

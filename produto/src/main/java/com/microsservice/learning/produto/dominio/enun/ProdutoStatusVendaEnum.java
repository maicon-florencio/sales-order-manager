package com.microsservice.learning.produto.dominio.enun;

import java.io.Serializable;

public enum ProdutoStatusVendaEnum implements Serializable {


    ATIVO("ATIVO", 1),
    DESATIVADO("DESATIVADO", 0);

    private String status;
    private Integer code;

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    ProdutoStatusVendaEnum(String status, Integer code) {
        this.status = status;
        this.code = code;
    }
}

package com.microsservice.learning.produto.dominio.enun;

import java.io.Serializable;

public enum TipoRefeicaoEnum implements Serializable {

    VEGETARIANO("Vegetariano", 1),
    VEGANO("Vegano",2);
    private String name;
    private int code;

     TipoRefeicaoEnum(String name, int code){
         this.name = name;
         this.code =code;
    }





}

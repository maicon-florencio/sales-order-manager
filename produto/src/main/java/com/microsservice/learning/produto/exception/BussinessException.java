package com.microsservice.learning.produto.exception;

public class BussinessException extends RuntimeException{

    public BussinessException(String msg){
        super(msg);
    }
}

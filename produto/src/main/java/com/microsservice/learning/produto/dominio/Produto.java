package com.microsservice.learning.produto.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Produto implements Serializable {
    @Id
    private Long id;
    private String name;
    private double price;
    private String desc;
    private String statusP;
    private LocalDate dtVencimento;

}

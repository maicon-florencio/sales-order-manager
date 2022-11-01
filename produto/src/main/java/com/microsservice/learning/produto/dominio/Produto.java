package com.microsservice.learning.produto.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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
    private String statusP;

}

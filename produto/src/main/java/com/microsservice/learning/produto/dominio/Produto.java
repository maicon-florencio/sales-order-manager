package com.microsservice.learning.produto.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;
    private float price;
    private String description;
    private String statusP;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "estoque_id",referencedColumnName = "id")
    private Estoque estoque;

    private Calendar dtVencimento;

}

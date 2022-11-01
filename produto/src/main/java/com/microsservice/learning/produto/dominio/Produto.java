package com.microsservice.learning.produto.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String name;
    private double price;
    private String desc;
    private String statusP;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    @Temporal(TemporalType.DATE)
    private Calendar dtVencimento;

}

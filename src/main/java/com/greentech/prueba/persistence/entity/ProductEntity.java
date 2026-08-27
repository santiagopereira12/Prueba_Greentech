package com.greentech.prueba.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table (name = "productos")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "tipo")
    private String type;
    @Column(name = "valor")
    private double value;
}

package com.sabora.server.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="nombre", length=30, nullable=false,unique = true)
    private String name;

    @Column(name="composicion", length=200, nullable=false)
    private String composition;

    @Column(name="grasas",nullable=false)
    private double fats;

    @Column(name="hidratos",nullable=false)
    private double carbohydrates;

    @Column(name="proteinas",nullable=false)
    private double proteins;

    @Column(name="sal", nullable = false)
    private double salt;

    @Column(name="calorias", nullable = false)
    private double calories;

}

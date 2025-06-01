package com.sabora.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "alimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodMO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "composicion", length = 200, nullable = false)
    private String composition;

    @Min(0)
    @Column(name = "grasas", nullable = false, precision = 10, scale = 2)
    private BigDecimal fats;

    @Min(0)
    @Column(name = "hidratos", nullable = false, precision = 10, scale = 2)
    private BigDecimal carbohydrates;

    @Min(0)
    @Column(name = "proteinas", nullable = false, precision = 10, scale = 2)
    private BigDecimal proteins;

    @Min(0)
    @Column(name = "sal", nullable = false, precision = 10, scale = 2)
    private BigDecimal salt;

    @Min(0)
    @Column(name = "calorias", nullable = false, precision = 10, scale = 2)
    private BigDecimal calories;

}

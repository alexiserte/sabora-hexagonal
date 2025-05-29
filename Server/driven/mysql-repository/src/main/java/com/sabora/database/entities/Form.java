package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "formulario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.DATE) // Solo la parte de la fecha (sin hora)
    @Column(name = "fecha_creacion", nullable = false)
    private Date date;

    @Column(name = "nombre", length = 750, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "dni", nullable = false)
    private FoodSpecialist author;

}

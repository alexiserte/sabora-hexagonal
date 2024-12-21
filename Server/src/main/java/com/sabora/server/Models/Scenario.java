package com.sabora.server.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "escenario")
public class Scenario {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", length=500, nullable=false, unique=true)
    private String name;

    @Column(name="lugar", length=500, nullable=false)
    private String place;

    @Column(name="foto", length = 500, nullable = false)
    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "id_sonido", referencedColumnName = "id")
    private Sound sound;

}

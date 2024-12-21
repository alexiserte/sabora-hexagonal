package com.sabora.server.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sonido")
public class Sound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "ruta", columnDefinition = "LONGTEXT", nullable = false)
    @Lob
    private String filepath;
}

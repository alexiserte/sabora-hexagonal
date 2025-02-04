package com.sabora.server.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sonido")
@Inheritance(strategy = InheritanceType.JOINED)
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

    @OneToMany(mappedBy = "sound", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienceSound> experiences = new ArrayList<>();

    public Sound(int id, String name, String filepath) {
        this.id = id;
        this.name = name;
        this.filepath = filepath;
    }
}

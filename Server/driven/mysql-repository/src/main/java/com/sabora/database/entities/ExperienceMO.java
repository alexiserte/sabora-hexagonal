package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "experiencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceMO {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="tiempo")
    private Long time;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "dni", nullable = false)
    private ClienteMO client;

    @ManyToOne
    @JoinColumn(name = "id_escenario", referencedColumnName = "id", nullable = false)
    private ScenarioMO scenario;

    @ManyToOne
    @JoinColumn(name = "id_sonido", referencedColumnName = "id", nullable = false)
    private SoundMO sound;

    @ManyToOne
    @JoinColumn(name = "id_alimento", referencedColumnName = "id", nullable = false)
    private FoodMO food;

    @OneToMany(mappedBy = "experience")
    private List<ExperienceSoundMO> sounds = new ArrayList<>();
}

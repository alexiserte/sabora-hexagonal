package com.sabora.server.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sonido_experiencia")
public class ExperienceSound {

    @EmbeddedId
    private ExperienceSoundID id;

    @ManyToOne
    @MapsId("experienceID")
    @JoinColumn(name = "id_experiencia")
    private Experience experience;

    @ManyToOne
    @MapsId("soundID")
    @JoinColumn(name = "id_sonido")
    private Sound sound;

}

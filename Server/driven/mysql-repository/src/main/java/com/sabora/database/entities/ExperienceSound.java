package com.sabora.database.entities;

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
    private ExperienceSoundID id = new ExperienceSoundID();

    @ManyToOne
    @MapsId("experienceID")
    @JoinColumn(name = "id_experiencia")
    private Experience experience;

    @ManyToOne
    @MapsId("soundID")
    @JoinColumn(name = "id_sonido")
    private Sound sound;

    public void setExperience(Experience experience) {
        this.experience = experience;
        this.id.setExperienceID(experience.getId());
    }

    public void setSound(Sound sound) {
        this.sound = sound;
        this.id.setSoundID(sound.getId());
    }


}

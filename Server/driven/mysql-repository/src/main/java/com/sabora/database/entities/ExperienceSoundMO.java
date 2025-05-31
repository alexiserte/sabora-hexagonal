package com.sabora.database.entities;

import com.sabora.database.entities.keys.ExperienceSoundID;
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
public class ExperienceSoundMO {

    @EmbeddedId
    private ExperienceSoundID id = new ExperienceSoundID();

    @ManyToOne
    @MapsId("experienceID")
    @JoinColumn(name = "id_experiencia")
    private ExperienceMO experience;

    @ManyToOne
    @MapsId("soundID")
    @JoinColumn(name = "id_sonido")
    private SoundMO sound;

    public void setExperience(ExperienceMO experience) {
        this.experience = experience;
        this.id.setExperienceID(experience.getId());
    }

    public void setSound(SoundMO sound) {
        this.sound = sound;
        this.id.setSoundID(sound.getId());
    }


}

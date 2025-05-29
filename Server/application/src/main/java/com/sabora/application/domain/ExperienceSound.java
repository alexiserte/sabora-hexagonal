package com.sabora.application.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExperienceSound {
    private ExperienceSoundID id = new ExperienceSoundID();
    private Experience experience;
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

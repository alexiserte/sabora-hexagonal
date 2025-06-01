package com.sabora.application.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExperienceSound {
    private ExperienceSoundID id;
    private Experience experience;
    private Sound sound;
}

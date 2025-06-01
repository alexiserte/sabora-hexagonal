package com.sabora.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExperienceSound {
    private ExperienceSoundID id;
    private Experience experience;
    private Sound sound;
}

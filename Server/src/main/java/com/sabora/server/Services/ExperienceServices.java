package com.sabora.server.Services;

import com.sabora.server.DTOs.ExperienceDTO;

public interface ExperienceServices {
    ExperienceDTO addExperience(ExperienceDTO experienceDTO);
    void endExperience(ExperienceDTO experienceDTO);
}

package com.sabora.server.Services;

import com.sabora.server.DTOs.ExperienceDTO;
import java.util.List;

public interface ExperienceServices {
    ExperienceDTO addExperience(ExperienceDTO experienceDTO);
    void endExperience(ExperienceDTO experienceDTO);
    List<ExperienceDTO> getUnfinishedExperiences(String client);
}

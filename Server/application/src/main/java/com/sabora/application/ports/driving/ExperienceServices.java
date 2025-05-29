package com.sabora.application.ports.driving;

import com.sabora.server.DTOs.ExperienceDTO;
import java.util.List;

public interface ExperienceServices {
    ExperienceDTO addExperience(ExperienceDTO experienceDTO);
    void endExperience(ExperienceDTO experienceDTO);
    List<ExperienceDTO> getUnfinishedExperiences(String client);
}

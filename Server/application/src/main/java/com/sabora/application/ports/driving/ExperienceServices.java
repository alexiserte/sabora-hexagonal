package com.sabora.application.ports.driving;

import com.sabora.application.domain.Experience;

import java.util.List;

public interface ExperienceServices {
    Experience addExperience(Experience experience);
    void endExperience(Experience experience);
    List<Experience> getUnfinishedExperiences(String client);
}

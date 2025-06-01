package com.sabora.application.ports.driven;


import com.sabora.application.domain.Experience;

import java.util.List;

public interface ExperienceRepositoryPort {
    Experience save(Experience experience);

    List<Experience> findByClientAndScenarioAndSoundAndFood(String client, String scenario, String sound, String food);

    Experience findById(int id);

    List<Experience> findAll();

}

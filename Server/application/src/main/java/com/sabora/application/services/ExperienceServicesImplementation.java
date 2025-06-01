package com.sabora.application.services;

import com.sabora.application.domain.Cliente;
import com.sabora.application.domain.Experience;
import com.sabora.application.ports.driven.*;
import com.sabora.application.ports.driving.ExperienceServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ExperienceServicesImplementation implements ExperienceServices {

    private final ExperienceRepositoryPort experienceRepository;
    private final ScenarioRepositoryPort scenarioRepository;
    private final SoundRepositoryPort soundRepository;
    private UserRepositoryPort userRepository;
    private FoodRepositoryPort foodRepository;

    @Override
    public Experience addExperience(Experience experience) {
        experience.setClient((Cliente) userRepository.findByUsername(experience.getClient().getUsername()));
        experience.setScenario(scenarioRepository.findByName(experience.getScenario().getName()));
        experience.setSound(soundRepository.findByName(experience.getSound().getName()));
        experience.setFood(foodRepository.findByName(experience.getFood().getName()));
        experienceRepository.save(experience);

        List<Experience> savedExperience = experienceRepository.findByClientAndScenarioAndSoundAndFood(experience.getClient().getName(), experience.getScenario().getName(), experience.getSound().getName(), experience.getFood().getName());
        experience.setId(savedExperience.getLast().getId());
        log.info("Experience added: {}", experience);
        return experience;
    }

    @Override
    public void endExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public List<Experience> getUnfinishedExperiences(String client) {
        Cliente cliente = (Cliente) userRepository.findByUsername(client);
        return experienceRepository.findAll().stream().filter(experience -> experience.getClient().equals(cliente) && experience.getTime() == null).toList();
    }
}

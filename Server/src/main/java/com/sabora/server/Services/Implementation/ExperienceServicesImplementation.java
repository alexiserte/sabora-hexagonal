package com.sabora.server.Services.Implementation;

import com.sabora.server.DTOs.ExperienceDTO;
import com.sabora.server.Entities.Cliente;
import com.sabora.server.Entities.Experience;
import com.sabora.server.Entities.ExperienceSound;
import com.sabora.server.Entities.Sound;
import com.sabora.server.Repositories.*;
import com.sabora.server.Services.ExperienceServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceServicesImplementation implements ExperienceServices {
    private final ExperienceRepository experienceRepository;
    private final ScenarioRepository scenarioRepository;
    private final SoundRepository soundRepository;
    private UserRepository userRepository;
    private FoodRepository foodRepository;

    public ExperienceServicesImplementation(ExperienceRepository experienceRepository, ScenarioRepository scenarioRepository, SoundRepository soundRepository, UserRepository userRepository, FoodRepository foodRepository) {
        this.experienceRepository = experienceRepository;
        this.scenarioRepository = scenarioRepository;
        this.soundRepository = soundRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }


    @Override
    public ExperienceDTO addExperience(ExperienceDTO experienceDTO) {
        Experience experience = new Experience();
        experience.setClient((Cliente) userRepository.findByUsername(experienceDTO.getClient()));
        experience.setScenario(scenarioRepository.findByName(experienceDTO.getScenario()));
        experience.setSound(soundRepository.findByName(experienceDTO.getSound()));
        experience.setFood(foodRepository.findByName(experienceDTO.getFood()));
        experienceRepository.save(experience);

        Experience savedExperience = experienceRepository.findByClientAndScenarioAndSoundAndFood(experience.getClient(), experience.getScenario(), experience.getSound(), experience.getFood());
        ExperienceDTO savedExperienceDTO = experienceDTO;
        savedExperienceDTO.setId(savedExperience.getId());
        return savedExperienceDTO;
    }

    @Override
    public void endExperience(ExperienceDTO experienceDTO) {
        List<ExperienceSound> experienceSounds = new ArrayList<>();
        Experience experience = experienceRepository.findById(experienceDTO.getId());
        long time = experienceDTO.getTime();
        List<String> sounds = experienceDTO.getSounds();
        for (String sound : sounds) {
            Sound sound1 = soundRepository.findByName(sound);
            ExperienceSound experienceSound = new ExperienceSound();
            experienceSound.setExperience(experience);
            experienceSound.setSound(sound1);
            experienceSounds.add(experienceSound);
        }
        experience.setSounds(experienceSounds);
        experience.setTime(time);
        experienceRepository.save(experience);
    }
}

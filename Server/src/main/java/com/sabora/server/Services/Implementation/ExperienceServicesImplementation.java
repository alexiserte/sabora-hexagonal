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
        // Buscar la experiencia por ID, asegurándote de que existe
        Experience experience = experienceRepository.findById(experienceDTO.getId());

        long time = experienceDTO.getTime();
        List<String> sounds = experienceDTO.getSounds();

        // Limpiar la lista actual de sounds
        experience.getSounds().clear();

        // Crear los nuevos ExperienceSound y asignarlos a la experiencia
        for (String soundName : sounds) {
            Sound sound = soundRepository.findByName(soundName);
            if (sound != null) {
                ExperienceSound experienceSound = new ExperienceSound();
                experienceSound.setExperience(experience);
                experienceSound.setSound(sound);
                experience.getSounds().add(experienceSound);  // Se agrega al listado de la experiencia
            } else {
                // Si el sonido no existe, lanzar una excepción o manejarlo de alguna forma
                throw new RuntimeException("Sound not found: " + soundName);
            }
        }

        // Actualizar el tiempo
        experience.setTime(time);

        // Guardar la experiencia con la lista actualizada de sounds
        experienceRepository.save(experience);
    }

    @Override
    public List<ExperienceDTO> getUnfinishedExperiences(String client) {
       List<ExperienceDTO> experiences = new ArrayList<>();
       Cliente cliente = (Cliente) userRepository.findByUsername(client);
       List<Experience> unfinishedExperiences = experienceRepository.findAll().stream().filter(experience -> experience.getClient().equals(cliente) && (experience.getTime() == 0 || experience.getTime() == null)).toList();
         for (Experience experience : unfinishedExperiences) {
             ExperienceDTO experienceDTO = getExperienceDTO(experience);
             experiences.add(experienceDTO);
         }
       return experiences;
    }

    private static ExperienceDTO getExperienceDTO(Experience experience) {
        ExperienceDTO experienceDTO = new ExperienceDTO();
        experienceDTO.setId(experience.getId());
        experienceDTO.setClient(experience.getClient().getUsername());
        experienceDTO.setScenario(experience.getScenario().getName());
        experienceDTO.setSound(experience.getSound().getName());
        experienceDTO.setFood(experience.getFood().getName());
        return experienceDTO;
    }
}

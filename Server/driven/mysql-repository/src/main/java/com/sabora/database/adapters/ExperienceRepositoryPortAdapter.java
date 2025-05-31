package com.sabora.database.adapters;

import com.sabora.application.domain.Experience;
import com.sabora.application.ports.driven.ExperienceRepositoryPort;
import com.sabora.database.entities.ClienteMO;
import com.sabora.database.mappers.ExperienceEntityMapper;
import com.sabora.database.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ExperienceRepositoryPortAdapter implements ExperienceRepositoryPort {

    private ExperienceJpaRepository experienceJpaRepository;
    private UserJpaRepository userJpaRepository;
    private ScenarioJpaRepository scenarioJpaRepository;
    private SoundJpaRepository soundJpaRepository;
    private FoodJpaRepository foodJpaRepository;

    private ExperienceEntityMapper experienceEntityMapper;

    @Override
    public Experience save(Experience experience) {
        return experienceEntityMapper.toDomain(
                experienceJpaRepository.save(
                        experienceEntityMapper.toEntity(experience)
                )
        );
    }

    @Override
    public List<Experience> findByClientAndScenarioAndSoundAndFood(String client, String scenario, String sound, String food) {
        var clientEntity = (ClienteMO) userJpaRepository.findByDni(client);
        var scenarioEntity = scenarioJpaRepository.findByName(scenario);
        var soundEntity = soundJpaRepository.findByName(sound);
        var foodEntity = foodJpaRepository.findByName(food);

        if (clientEntity == null || scenarioEntity == null || soundEntity == null || foodEntity == null) {
            throw new RuntimeException(
                    "Client, scenario, sound, or food not found: " +
                    "client=" + client + ", scenario=" + scenario +
                    ", sound=" + sound + ", food=" + food
            );
        }

        return experienceJpaRepository.findByClientAndScenarioAndSoundAndFood(
                clientEntity, scenarioEntity, soundEntity, foodEntity
        ).stream()
                .map(experienceEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Experience findById(int id) {
        return experienceEntityMapper.toDomain(
                experienceJpaRepository.findById(id));
    }

    @Override
    public List<Experience> findAll() {
        return experienceJpaRepository.findAll().stream()
                .map(experienceEntityMapper::toDomain)
                .toList();
    }
}

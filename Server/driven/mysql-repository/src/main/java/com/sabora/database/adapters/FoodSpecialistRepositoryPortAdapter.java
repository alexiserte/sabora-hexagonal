package com.sabora.database.adapters;

import com.sabora.application.domain.FoodSpecialist;
import com.sabora.application.ports.driven.FoodSpecialistRepositoryPort;
import com.sabora.database.mappers.FoodSpecialistEntityMapper;
import com.sabora.database.repositories.FoodSpecialistJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FoodSpecialistRepositoryPortAdapter implements FoodSpecialistRepositoryPort {

    private final FoodSpecialistJpaRepository foodSpecialistJpaRepository;
    private final FoodSpecialistEntityMapper foodSpecialistMapper;

    @Override
    public FoodSpecialist save(FoodSpecialist foodSpecialist) {
        return foodSpecialistMapper.toDomain(
                foodSpecialistJpaRepository.save(foodSpecialistMapper.toEntity(foodSpecialist))
        );
    }

    @Override
    public List<FoodSpecialist> findAll() {
        return foodSpecialistJpaRepository
                .findAll()
                .stream()
                .map(foodSpecialistMapper::toDomain)
                .toList();
    }
}

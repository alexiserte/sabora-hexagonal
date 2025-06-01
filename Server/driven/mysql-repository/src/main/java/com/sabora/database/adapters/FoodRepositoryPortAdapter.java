package com.sabora.database.adapters;

import com.sabora.application.domain.Food;
import com.sabora.application.ports.driven.FoodRepositoryPort;
import com.sabora.database.mappers.FoodEntityMapper;
import com.sabora.database.repositories.FoodJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class FoodRepositoryPortAdapter implements FoodRepositoryPort {

    private FoodEntityMapper mapper;
    private FoodJpaRepository foodJpaRepository;

    @Override
    public Food findByName(String name) {
        return mapper.toDomain(foodJpaRepository.findByName(name));
    }

    @Override
    public Food save(Food food) {
        return mapper.toDomain(foodJpaRepository.save(mapper.toEntity(food)));
    }

    @Override
    public void delete(Food food) {
        foodJpaRepository.delete(mapper.toEntity(food));
    }

    @Override
    public List<Food> findAll() {
        return foodJpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

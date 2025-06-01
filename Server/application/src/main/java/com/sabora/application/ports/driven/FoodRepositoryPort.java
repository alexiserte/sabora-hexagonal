package com.sabora.application.ports.driven;

import com.sabora.application.domain.Food;

import java.util.List;

public interface FoodRepositoryPort {
    Food findByName(String name);

    Food save(Food food);

    void delete(Food food);

    List<Food> findAll();
}

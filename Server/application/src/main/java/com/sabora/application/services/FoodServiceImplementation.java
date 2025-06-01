package com.sabora.application.services;


import com.sabora.application.domain.Food;
import com.sabora.application.ports.driven.FoodRepositoryPort;
import com.sabora.application.ports.driving.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodServiceImplementation implements FoodService {

    private final FoodRepositoryPort foodRepository;


    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void removeFood(Food food) {
        foodRepository.delete(food);
    }

    @Override
    public Food getFood(String name) {
        List<Food> foods = foodRepository.findAll();
        for(Food food: foods){
            if(food.getName().equals(name)){
                return food;
            }
        }
        return null;
    }

    @Override
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getHighCalorieFoods(List<Food> foods) {
        List<Food> highCalorieFoods = new ArrayList<>();
        for(Food food: foods){
            if(food.getCalories().compareTo(BigDecimal.valueOf(2000)) == 1){
                highCalorieFoods.add(food);
            }
        }
        return highCalorieFoods;
    }
}

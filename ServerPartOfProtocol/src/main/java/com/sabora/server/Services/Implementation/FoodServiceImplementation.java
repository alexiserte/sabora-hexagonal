package com.sabora.server.Services.Implementation;

import com.sabora.server.Models.Food;
import com.sabora.server.Repositories.FoodRepository;
import com.sabora.server.Services.FoodService;

import java.util.List;

public class FoodServiceImplementation implements FoodService {

    private final FoodRepository foodRepository;

    public FoodServiceImplementation(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

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
}

package com.sabora.application.ports.driving;

import com.sabora.server.Entities.Food;

import java.util.List;

public interface FoodService {
    void addFood(Food food);
    void removeFood(Food food);
    Food getFood(String name);
    List<Food> getAllFoods();
    List<Food> getHighCalorieFoods(List<Food> foods);
}

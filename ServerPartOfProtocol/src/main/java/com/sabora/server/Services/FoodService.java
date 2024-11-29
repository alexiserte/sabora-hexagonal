package com.sabora.server.Services;

import com.sabora.server.Models.Food;

public interface FoodService {
    void addFood(Food food);
    void removeFood(Food food);
    Food getFood(String name);
}

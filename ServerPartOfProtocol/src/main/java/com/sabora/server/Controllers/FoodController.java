package com.sabora.server.Controllers;

import com.sabora.server.Models.Food;
import com.sabora.server.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping("/food")
    public String getFood(){
        return "Food";
    }

    @PostMapping("/food")
    public String postFood(){
        Food food = new Food();
        food.setName("Pizza");
        food.setCalories(BigDecimal.valueOf(300));
        food.setCarbohydrates(BigDecimal.valueOf(30));
        food.setComposition("Pizza with cheese");
        food.setFats(BigDecimal.valueOf(10));
        food.setProteins(BigDecimal.valueOf(20));
        food.setSalt(BigDecimal.valueOf(5));
        foodService.addFood(food);
        return "Food added";
    }
}

package com.sabora.server.Controllers;

import com.sabora.server.Models.Food;
import com.sabora.server.Services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
        foodService.addFood(new Food());
        return "Food added";
    }
}

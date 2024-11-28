package com.sabora.server.Services;

import com.sabora.server.Models.Food;
import com.sabora.server.Repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private  FoodRepository foodRepository;


    public void addFood(Food food) {
        foodRepository.save(food);
        System.out.println("Food added");
    }


}

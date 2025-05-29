package com.sabora.api.dtos;

import com.sabora.server.Entities.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String name;
    private String composition;
    private BigDecimal fats;
    private BigDecimal carbohydrates;
    private BigDecimal proteins;
    private BigDecimal salt;
    private BigDecimal calories;

    public FoodDTO(Food food) {
        this.name = food.getName();
        this.composition = food.getComposition();
        this.fats = food.getFats();
        this.carbohydrates = food.getCarbohydrates();
        this.proteins = food.getProteins();
        this.salt = food.getSalt();
        this.calories = food.getCalories();
    }
}

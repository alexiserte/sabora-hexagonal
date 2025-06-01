package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodDTO {
    private String name;
    private String composition;
    private BigDecimal fats;
    private BigDecimal carbohydrates;
    private BigDecimal proteins;
    private BigDecimal salt;
    private BigDecimal calories;
}

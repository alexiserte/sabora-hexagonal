package com.sabora.api.mappers;

import com.sabora.api.dtos.FoodDTO;
import com.sabora.application.domain.Food;

public interface FoodDTOMapper {
    FoodDTO toDTO(Food food);
    Food toDomain(FoodDTO foodDTO);
}

package com.sabora.server.Mappers;

import com.sabora.server.DTOs.FoodDTO;
import com.sabora.server.Models.Food;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    @Mapping(target = "id", ignore = true)
    Food toEntity(FoodDTO food);

    FoodDTO toFood(Food food);
}

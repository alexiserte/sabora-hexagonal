package com.sabora.server.Mappers;

import com.sabora.server.DTOs.FoodDTO;
import com.sabora.server.Models.Food;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface FoodMapper {
    @Mapping(target = "id", ignore = true)
    Food toEntity(FoodDTO food);

    FoodDTO toFoodDTO(Food food);
}

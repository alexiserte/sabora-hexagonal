package com.sabora.database.mappers;

import com.sabora.application.domain.Food;
import com.sabora.database.entities.FoodMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodEntityMapper {
    FoodMO toEntity(Food food);

    Food toDomain(FoodMO foodMO);
}

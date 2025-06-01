package com.sabora.api.mappers;

import com.sabora.application.domain.Food;
import org.mapstruct.Mapper;
import org.openapitools.model.FoodDTO;

@Mapper(componentModel = "spring")
public interface FoodDTOMapper {
    FoodDTO toDTO(Food food);

    Food toDomain(FoodDTO foodDTO);
}

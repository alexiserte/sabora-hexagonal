package com.sabora.database.mappers;

import com.sabora.application.domain.FoodSpecialist;
import com.sabora.database.entities.FoodSpecialistMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodSpecialistEntityMapper {
    FoodSpecialistMO toEntity(FoodSpecialist foodSpecialistMO);

    FoodSpecialist toDomain(FoodSpecialistMO foodSpecialistMO);
}

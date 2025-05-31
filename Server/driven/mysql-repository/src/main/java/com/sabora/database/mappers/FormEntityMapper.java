package com.sabora.database.mappers;

import com.sabora.application.domain.Form;
import com.sabora.database.entities.FormMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {FoodSpecialistEntityMapper.class})
public interface FormEntityMapper {
    FormMO toEntity(Form form);
    Form toDomain(FormMO formMO);
}

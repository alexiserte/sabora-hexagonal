package com.sabora.api.mappers;

import com.sabora.api.dtos.FormAnswerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormAnswerDTOMapper {
    FormAnswerDTO toDTO(FormAnswer)
}

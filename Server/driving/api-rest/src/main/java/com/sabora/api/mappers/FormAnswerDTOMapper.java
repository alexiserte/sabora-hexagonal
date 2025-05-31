package com.sabora.api.mappers;

import com.sabora.api.dtos.FormAnswerDTO;
import com.sabora.application.domain.FormAnswer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AnswerDTOMapper.class)
public interface FormAnswerDTOMapper {
    FormAnswerDTO toMapSimple(FormAnswer formAnswer);
    FormAnswer toDomain(FormAnswerDTO formAnswerDTO);
}

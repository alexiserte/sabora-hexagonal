package com.sabora.api.mappers;

import com.sabora.application.domain.FormAnswer;
import org.mapstruct.Mapper;
import org.openapitools.model.FormAnswerDTO;

@Mapper(componentModel = "spring", uses = AnswerDTOMapper.class)
public interface FormAnswerDTOMapper {
    FormAnswerDTO toMapSimple(FormAnswer formAnswer);

    FormAnswer toDomain(FormAnswerDTO formAnswerDTO);
}

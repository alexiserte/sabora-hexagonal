package com.sabora.api.mappers.questionmapper;

import com.sabora.application.domain.UniqueAnswerQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.UniqueAnswerQuestionDTO;


@Mapper(componentModel = "spring", uses = QuestionOptionMapper.class)
public interface UniqueAnswerQuestionMapper {

    @Mapping(target = "options", source = "options")
    UniqueAnswerQuestion toEntity(UniqueAnswerQuestionDTO dto);

    @Mapping(target = "options", source = "options")
    UniqueAnswerQuestionDTO toDTO(UniqueAnswerQuestion entity);
}
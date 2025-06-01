package com.sabora.api.mappers.questionmapper;


import com.sabora.application.domain.MultipleAnswerQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.MultipleAnswerQuestionDTO;

@Mapper(componentModel = "spring", uses = QuestionOptionMapper.class)
public interface MultipleAnswerQuestionMapper {

    @Mapping(target = "options", source = "options")
    MultipleAnswerQuestion toEntity(MultipleAnswerQuestionDTO dto);

    @Mapping(target = "options", source = "options")
    MultipleAnswerQuestionDTO toDTO(MultipleAnswerQuestion entity);
}
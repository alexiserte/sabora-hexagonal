package com.sabora.api.mappers.questionmapper;

import com.sabora.application.domain.AnswerWritingQuestion;
import org.mapstruct.Mapper;
import org.openapitools.model.AnswerRedactionQuestionDTO;

@Mapper(componentModel = "spring")
public interface AnswerWritingQuestionMapper {

    AnswerWritingQuestion toEntity(AnswerRedactionQuestionDTO dto);

    AnswerRedactionQuestionDTO toDTO(AnswerWritingQuestion entity);
}

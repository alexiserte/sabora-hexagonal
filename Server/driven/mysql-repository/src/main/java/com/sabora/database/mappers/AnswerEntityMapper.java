package com.sabora.database.mappers;

import com.sabora.application.domain.Answer;
import com.sabora.database.entities.AnswerMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {QuestionEntityMapper.class, ExperienceEntityMapper.class})
public interface AnswerEntityMapper {
    Answer toDomain(AnswerMO answerMO);

    AnswerMO toEntity(Answer answer);
}

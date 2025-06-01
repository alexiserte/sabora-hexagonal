package com.sabora.api.mappers;

import com.sabora.api.dtos.AnswerDTO;
import com.sabora.api.dtos.FormAnswerDTO;
import com.sabora.application.domain.Answer;
import com.sabora.application.domain.Experience;
import com.sabora.application.domain.Question;
import org.mapstruct.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AnswerDTOMapper {
    default List<Answer> toDomainAnswers(List<AnswerDTO> answerDTOs, FormAnswerDTO form) {
        if (form.getAnswers() == null) {
            throw new IllegalArgumentException("AnswerDTO list cannot be null");
        }

        return answerDTOs.stream()
                .map(answerDTO ->
                        Answer.builder()
                                .id(answerDTO.getId())
                                .answerTimeStamp(LocalDateTime.now())
                                .author(form.getUserIdentifier())
                                .value(answerDTO.getAnswer())
                                .question(Question.builder().id(answerDTO.getQuestionId()).build())
                                .experience(Experience.builder().id(form.getExperienceId()).build())
                                .build()
                )
                .collect(Collectors.toList());
    }
}

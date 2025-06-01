package com.sabora.api.mappers;

import com.sabora.application.domain.*;
import org.mapstruct.Mapper;
import org.openapitools.model.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDTOMapper {
    RangeQuestion toDomain(RangeQuestionDTO dto);
    RangeQuestionDTO toDTO(RangeQuestion domain);

    MultipleAnswerQuestion toDomain(MultipleAnswerQuestionDTO dto);
    MultipleAnswerQuestionDTO toDTO(MultipleAnswerQuestion domain);

    UniqueAnswerQuestion toDomain(UniqueAnswerQuestionDTO dto);
    UniqueAnswerQuestionDTO toDTO(UniqueAnswerQuestion domain);

    AnswerWritingQuestion toDomain(AnswerRedactionQuestionDTO dto);
    AnswerRedactionQuestionDTO toDTO(AnswerWritingQuestion domain);

    default Question toDomain(QuestionDTO dto) {

        if (dto instanceof RangeQuestionDTO) {
            var question =  toDomain((RangeQuestionDTO) dto);
            question.setTitle(dto.getQuestion());
            return question;
        } else if (dto instanceof MultipleAnswerQuestionDTO) {
            var question = toDomain((MultipleAnswerQuestionDTO) dto);
            question.setTitle(dto.getQuestion());
            return question;
        } else if (dto instanceof UniqueAnswerQuestionDTO) {
            var question = toDomain((UniqueAnswerQuestionDTO) dto);
            question.setTitle(dto.getQuestion());
            return question;
        } else if (dto instanceof AnswerRedactionQuestionDTO) {
            var question = toDomain((AnswerRedactionQuestionDTO) dto);
            question.setTitle(dto.getQuestion());
            return question;
        } else {
            throw new IllegalArgumentException("Unknown QuestionDTO subtype: " + dto.getClass());
        }
    }

    default QuestionDTO toDTO(Question domain) {
        if (domain instanceof RangeQuestion) {
            return toDTO((RangeQuestion) domain);
        } else if (domain instanceof MultipleAnswerQuestion) {
            return toDTO((MultipleAnswerQuestion) domain);
        } else if (domain instanceof UniqueAnswerQuestion) {
            return toDTO((UniqueAnswerQuestion) domain);
        } else if (domain instanceof AnswerWritingQuestion) {
            return toDTO((AnswerWritingQuestion) domain);
        } else {
            throw new IllegalArgumentException("Unknown Question subtype: " + domain.getClass());
        }
    }

    default List<String> toOptionsList(List<QuestionOption> options) {
        return options.stream()
                .map(QuestionOption::getText)
                .toList();
    }

    default List<QuestionOption> toOptionsDomainList(List<String> options) {
        return options.stream()
                .map(option -> QuestionOption.builder().text(option).build())
                .toList();
    }
}

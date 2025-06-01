package com.sabora.api.mappers;

import com.sabora.application.domain.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionDTOMapper {

    @Mapping(target = "title", source = "question")
    RangeQuestion toDomain(RangeQuestionDTO dto);

    @InheritInverseConfiguration
    RangeQuestionDTO toDTO(RangeQuestion domain);

    @Mapping(target = "title", source = "question")
    MultipleAnswerQuestion toDomain(MultipleAnswerQuestionDTO dto);

    @InheritInverseConfiguration
    MultipleAnswerQuestionDTO toDTO(MultipleAnswerQuestion domain);

    @Mapping(target = "title", source = "question")
    UniqueAnswerQuestion toDomain(UniqueAnswerQuestionDTO dto);

    @InheritInverseConfiguration
    UniqueAnswerQuestionDTO toDTO(UniqueAnswerQuestion domain);

    @Mapping(target = "title", source = "question")
    AnswerWritingQuestion toDomain(AnswerRedactionQuestionDTO dto);

    @InheritInverseConfiguration
    AnswerRedactionQuestionDTO toDTO(AnswerWritingQuestion domain);

    default Question toDomain(QuestionDTO dto) {
        if (dto instanceof RangeQuestionDTO) {
            return toDomain((RangeQuestionDTO) dto);
        } else if (dto instanceof MultipleAnswerQuestionDTO) {
            return toDomain((MultipleAnswerQuestionDTO) dto);
        } else if (dto instanceof UniqueAnswerQuestionDTO) {
            return toDomain((UniqueAnswerQuestionDTO) dto);
        } else if (dto instanceof AnswerRedactionQuestionDTO) {
            return toDomain((AnswerRedactionQuestionDTO) dto);
        }
        throw new IllegalArgumentException("Unknown QuestionDTO subtype: " + dto.getClass());
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
        }
        throw new IllegalArgumentException("Unknown Question subtype: " + domain.getClass());
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

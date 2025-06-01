package com.sabora.api.mappers;

import com.sabora.api.mappers.questionmapper.*;
import com.sabora.application.domain.*;
import org.mapstruct.Mapper;
import org.mapstruct.SubclassMapping;
import org.openapitools.model.*;

@Mapper(componentModel = "spring", uses = {
        MultipleAnswerQuestionMapper.class,
        UniqueAnswerQuestionMapper.class,
        RangeQuestionMapper.class,
        AnswerWritingQuestionMapper.class
})
public interface QuestionDTOMapper {

    @SubclassMapping(source = RangeQuestionDTO.class, target = RangeQuestion.class)
    @SubclassMapping(source = MultipleAnswerQuestionDTO.class, target = MultipleAnswerQuestion.class)
    @SubclassMapping(source = UniqueAnswerQuestionDTO.class, target = UniqueAnswerQuestion.class)
    @SubclassMapping(source = AnswerRedactionQuestionDTO.class, target = AnswerWritingQuestion.class)
    Question toEntity(QuestionDTO dto);

    @SubclassMapping(source = RangeQuestion.class, target = RangeQuestionDTO.class)
    @SubclassMapping(source = MultipleAnswerQuestion.class, target = MultipleAnswerQuestionDTO.class)
    @SubclassMapping(source = UniqueAnswerQuestion.class, target = UniqueAnswerQuestionDTO.class)
    @SubclassMapping(source = AnswerWritingQuestion.class, target = AnswerRedactionQuestionDTO.class)
    QuestionDTO toDTO(Question entity);
}

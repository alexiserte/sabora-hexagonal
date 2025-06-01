package com.sabora.api.mappers.questionmapper;

import com.sabora.application.domain.RangeQuestion;
import org.mapstruct.Mapper;
import org.openapitools.model.RangeQuestionDTO;

@Mapper(componentModel = "spring")
public interface RangeQuestionMapper {

    RangeQuestion toEntity(RangeQuestionDTO dto);

    RangeQuestionDTO toDTO(RangeQuestion entity);
}

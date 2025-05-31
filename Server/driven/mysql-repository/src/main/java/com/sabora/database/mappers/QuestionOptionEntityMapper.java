package com.sabora.database.mappers;

import com.sabora.application.domain.QuestionOption;
import com.sabora.database.entities.QuestionOptionMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {QuestionEntityMapper.class})
public interface QuestionOptionEntityMapper {
    QuestionOptionMO toEntity(QuestionOption questionOptionMO);
    QuestionOption toDomain(QuestionOptionMO questionOptionMO);
}

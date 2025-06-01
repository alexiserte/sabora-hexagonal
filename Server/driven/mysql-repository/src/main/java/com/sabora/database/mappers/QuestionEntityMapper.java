package com.sabora.database.mappers;

import com.sabora.application.domain.Question;
import com.sabora.database.entities.QuestionMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FormEntityMapper.class, QuestionEntityMapper.class})
public interface QuestionEntityMapper {
    QuestionMO toEntity(Question questionMO);

    Question toDomain(QuestionMO questionMO);
}

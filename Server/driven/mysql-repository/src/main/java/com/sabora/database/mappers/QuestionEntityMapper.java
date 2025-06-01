package com.sabora.database.mappers;

import com.sabora.application.domain.Question;
import com.sabora.database.entities.QuestionMO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FormEntityMapper.class, QuestionEntityMapper.class})
public interface QuestionEntityMapper {

    @Mapping(target = "form", ignore = true)
    QuestionMO toEntity(Question questionMO);

    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", ignore = true)
    Question toDomain(QuestionMO questionMO);
}

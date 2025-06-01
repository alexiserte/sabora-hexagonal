package com.sabora.database.mappers;

import com.sabora.application.domain.*;
import com.sabora.database.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FormEntityMapper.class})
public interface QuestionEntityMapper {

    // El método genérico que mapea de entidad (JPA) a dominio (MO)
    @Mapping(target = "form", ignore = true)
    QuestionMO toDomain(QuestionMO entity);

    // Métodos específicos para cada subtipo de entidad a MO
    AnswerWritingQuestion toDomain(AnswerWritingQuestionMO entity);

    MultipleAnswerQuestion toDomain(MultipleAnswerQuestionMO entity);

    RangeQuestion toDomain(RangeQuestionMO entity);

    UniqueAnswerQuestion toDomain(UniqueAnswerQuestionMO entity);


    @Mapping(target = "form", ignore = true)
    QuestionMO toEntity(Question questionMO);

    // Métodos específicos de dominio a entidad para los subtipos
    AnswerWritingQuestionMO toEntity(AnswerWritingQuestion questionMO);

    MultipleAnswerQuestionMO toEntity(MultipleAnswerQuestion questionMO);

    RangeQuestionMO toEntity(RangeQuestion questionMO);

    UniqueAnswerQuestionMO toEntity(UniqueAnswerQuestion questionMO);

    // Método por defecto para que MapStruct elija según instancia
    default Question mapPolymorphic(QuestionMO entity) {
        if (entity instanceof AnswerWritingQuestionMO e) return toDomain(e);
        if (entity instanceof MultipleAnswerQuestionMO e) return toDomain(e);
        if (entity instanceof RangeQuestionMO e) return toDomain(e);
        if (entity instanceof UniqueAnswerQuestionMO e) return toDomain(e);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + entity.getClass());
    }

    default QuestionMO mapPolymorphic(Question questionMO) {
        if (questionMO instanceof AnswerWritingQuestion q) return toEntity(q);
        if (questionMO instanceof MultipleAnswerQuestion q) return toEntity(q);
        if (questionMO instanceof RangeQuestion q) return toEntity(q);
        if (questionMO instanceof UniqueAnswerQuestion q) return toEntity(q);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + questionMO.getClass());
    }
}

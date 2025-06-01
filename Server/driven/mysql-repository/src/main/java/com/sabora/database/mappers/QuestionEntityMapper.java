package com.sabora.database.mappers;

import com.sabora.application.domain.*; // dominio, sin MO
import com.sabora.database.entities.*;  // entidades, con MO
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {FormEntityMapper.class})
public interface QuestionEntityMapper {

    // Mapea de entidad (MO) a dominio (sin MO)
    @Mapping(target = "form", ignore = true)
    Question toDomain(QuestionMO entity);

    AnswerWritingQuestion toDomain(AnswerWritingQuestionMO entity);

    MultipleAnswerQuestion toDomain(MultipleAnswerQuestionMO entity);

    RangeQuestion toDomain(RangeQuestionMO entity);

    UniqueAnswerQuestion toDomain(UniqueAnswerQuestionMO entity);

    // Mapea de dominio a entidad
    @Mapping(target = "form", ignore = true)
    QuestionMO toEntity(Question domain);

    AnswerWritingQuestionMO toEntity(AnswerWritingQuestion domain);

    MultipleAnswerQuestionMO toEntity(MultipleAnswerQuestion domain);

    RangeQuestionMO toEntity(RangeQuestion domain);

    UniqueAnswerQuestionMO toEntity(UniqueAnswerQuestion domain);

    // Métodos polimórficos para que MapStruct elija según instancia

    default Question mapPolymorphic(QuestionMO entity) {
        if (entity instanceof AnswerWritingQuestionMO e) return toDomain(e);
        if (entity instanceof MultipleAnswerQuestionMO e) return toDomain(e);
        if (entity instanceof RangeQuestionMO e) return toDomain(e);
        if (entity instanceof UniqueAnswerQuestionMO e) return toDomain(e);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + entity.getClass());
    }

    default QuestionMO mapPolymorphic(Question domain) {
        if (domain instanceof AnswerWritingQuestion q) return toEntity(q);
        if (domain instanceof MultipleAnswerQuestion q) return toEntity(q);
        if (domain instanceof RangeQuestion q) return toEntity(q);
        if (domain instanceof UniqueAnswerQuestion q) return toEntity(q);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + domain.getClass());
    }
}

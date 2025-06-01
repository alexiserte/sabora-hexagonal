package com.sabora.database.mappers;

import com.sabora.application.domain.*;
import com.sabora.database.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {FormEntityMapper.class})
public interface QuestionEntityMapper {

    // Evitar mapear el form para evitar recursión
    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsWithoutQuestion")
    Question toDomain(QuestionMO entity);

    // Métodos específicos para cada subtipo de entidad a dominio (sin form, y sin mapear opciones con ciclo)
    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsWithoutQuestion")
    AnswerWritingQuestion toDomain(AnswerWritingQuestionMO entity);

    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsWithoutQuestion")
    MultipleAnswerQuestion toDomain(MultipleAnswerQuestionMO entity);

    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsWithoutQuestion")
    RangeQuestion toDomain(RangeQuestionMO entity);

    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsWithoutQuestion")
    UniqueAnswerQuestion toDomain(UniqueAnswerQuestionMO entity);

    // Mapeo de dominio a entidad
    @Mapping(target = "form", ignore = true)
    @Mapping(target = "options", qualifiedByName = "mapOptionsToEntityWithoutQuestion")
    QuestionMO toEntity(Question question);

    AnswerWritingQuestionMO toEntity(AnswerWritingQuestion question);

    MultipleAnswerQuestionMO toEntity(MultipleAnswerQuestion question);

    RangeQuestionMO toEntity(RangeQuestion question);

    UniqueAnswerQuestionMO toEntity(UniqueAnswerQuestion question);

    // Métodos polimórficos para evitar ambigüedad
    @Named("mapPolymorphicToDomain")
    default Question mapPolymorphicToDomain(QuestionMO entity) {
        if (entity instanceof AnswerWritingQuestionMO e) return toDomain(e);
        if (entity instanceof MultipleAnswerQuestionMO e) return toDomain(e);
        if (entity instanceof RangeQuestionMO e) return toDomain(e);
        if (entity instanceof UniqueAnswerQuestionMO e) return toDomain(e);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + entity.getClass());
    }

    @Named("mapPolymorphicToEntity")
    default QuestionMO mapPolymorphicToEntity(Question question) {
        if (question instanceof AnswerWritingQuestion q) return toEntity(q);
        if (question instanceof MultipleAnswerQuestion q) return toEntity(q);
        if (question instanceof RangeQuestion q) return toEntity(q);
        if (question instanceof UniqueAnswerQuestion q) return toEntity(q);
        throw new IllegalArgumentException("Tipo de pregunta no soportado: " + question.getClass());
    }

    // Mapear lista de opciones sin mapear la pregunta padre para romper la recursión
    @Named("mapOptionsWithoutQuestion")
    default List<QuestionOption> mapOptionsWithoutQuestion(List<QuestionOptionMO> options) {
        if (options == null) return null;
        return options.stream()
                .map(this::toOptionShallow)
                .collect(Collectors.toList());
    }

    // Mapear opción sin mapear campo question para evitar recursión infinita
    @Named("toOptionShallow")
    @Mapping(target = "question", ignore = true)
    QuestionOption toOptionShallow(QuestionOptionMO optionMO);

    // Mapeo inverso: lista opciones sin pregunta padre
    @Named("mapOptionsToEntityWithoutQuestion")
    default List<QuestionOptionMO> mapOptionsToEntityWithoutQuestion(List<QuestionOption> options) {
        if (options == null) return null;
        return options.stream()
                .map(this::toOptionEntityShallow)
                .collect(Collectors.toList());
    }

    // Mapear opción dominio a entidad sin pregunta para evitar recursión
    @Named("toOptionEntityShallow")
    @Mapping(target = "question", ignore = true)
    QuestionOptionMO toOptionEntityShallow(QuestionOption option);
}

package com.sabora.api.mappers.questionmapper;

import com.sabora.application.domain.QuestionOption;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionOptionMapper {

    default QuestionOption fromString(String text) {
        QuestionOption option = new QuestionOption();
        option.setText(text);
        return option;
    }

    default String toString(QuestionOption option) {
        return option.getText();
    }

    List<QuestionOption> fromStrings(List<String> texts);
    List<String> toStrings(List<QuestionOption> options);
}

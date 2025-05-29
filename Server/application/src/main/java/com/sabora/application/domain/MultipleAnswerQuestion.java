package com.sabora.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultipleAnswerQuestion extends Question{

    @Builder
    public MultipleAnswerQuestion(int id, String value, Form form, List<QuestionOption> options) {
        super(id, value, form, options);
    }

}
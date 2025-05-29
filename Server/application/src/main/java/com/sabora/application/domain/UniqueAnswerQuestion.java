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
public class UniqueAnswerQuestion extends Question {

    @Builder
    public UniqueAnswerQuestion(int id, String value, Form form, List<QuestionOption> options) {
        super(id, value, form, options);
    }

}
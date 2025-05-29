package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultipleAnswerQuestionDTO extends QuestionDTO {
    private List<String> options;

    public MultipleAnswerQuestionDTO(int id, String question, List<String> options) {
        super(id, question);
        this.options = options;
    }
}

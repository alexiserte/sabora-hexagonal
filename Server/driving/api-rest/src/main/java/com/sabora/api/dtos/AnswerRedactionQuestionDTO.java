package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AnswerRedactionQuestionDTO extends QuestionDTO {

    public AnswerRedactionQuestionDTO(int id, String question) {
        super(id, question);
    }
}

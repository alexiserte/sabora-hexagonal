package com.sabora.server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRedactionQuestionDTO extends QuestionDTO {

    public AnswerRedactionQuestionDTO(int id, String question) {
        super(id, question);
    }
}

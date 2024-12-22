package com.sabora.server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RangeQuestionDTO extends QuestionDTO {
    private int min;
    private int max;
    private int interval;

    public RangeQuestionDTO(int id, String question, int min, int max, int interval) {
        super(id, question);
        this.min = min;
        this.max = max;
        this.interval = interval;
    }
}

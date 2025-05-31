package com.sabora.api.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RangeQuestionDTO extends QuestionDTO {
    private int min;
    private int max;
    private int interval;
}

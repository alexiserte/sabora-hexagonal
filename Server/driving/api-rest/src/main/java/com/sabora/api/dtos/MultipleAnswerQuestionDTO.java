package com.sabora.api.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class MultipleAnswerQuestionDTO extends QuestionDTO {
    private List<String> options;
}

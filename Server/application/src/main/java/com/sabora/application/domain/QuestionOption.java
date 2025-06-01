package com.sabora.application.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionOption {

    private int id;
    private String text;
    private Question question;

}

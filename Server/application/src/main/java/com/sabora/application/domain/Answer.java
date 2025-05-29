package com.sabora.application.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {

    private int id;
    private String value;
    private Question question;
    private Experience experience;
    private java.time.LocalDateTime answerTimeStamp;
    private String author;
}

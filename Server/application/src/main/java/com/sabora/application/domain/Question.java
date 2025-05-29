package com.sabora.application.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {

    private int id;
    private String title;
    private Form form;
    private List<QuestionOption> options = new ArrayList<>();
}

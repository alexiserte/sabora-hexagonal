package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "redaccion_respuesta")
@PrimaryKeyJoinColumn(name = "id_pregunta")
public class AnswerWritingQuestion extends Question{

    @Builder
    public AnswerWritingQuestion(int id, String value, Form form, List<QuestionOption> options) {
        super(id, value, form, options);
    }

}
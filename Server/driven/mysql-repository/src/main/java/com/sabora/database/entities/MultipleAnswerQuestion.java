package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "respuesta_multiple")
@PrimaryKeyJoinColumn(name = "id_pregunta")
public class MultipleAnswerQuestion extends Question{

    @Builder
    public MultipleAnswerQuestion(int id, String value, Form form, List<QuestionOption> options) {
        super(id, value, form, options);
    }

}
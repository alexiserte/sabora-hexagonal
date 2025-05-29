package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "respuesta_unica")
@PrimaryKeyJoinColumn(name = "id_pregunta")
public class UniqueAnswerQuestion extends Question{

    @Builder
    public UniqueAnswerQuestion(int id, String value, Form form, List<QuestionOption> options) {
        super(id, value, form, options);
    }

}
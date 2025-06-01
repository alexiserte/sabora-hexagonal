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
public class AnswerWritingQuestionMO extends QuestionMO {

    @Builder
    public AnswerWritingQuestionMO(int id, String value, FormMO form, List<QuestionOptionMO> options) {
        super(id, value, form, options);
    }

}
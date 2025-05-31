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
public class MultipleAnswerQuestionMO extends QuestionMO {

    @Builder
    public MultipleAnswerQuestionMO(int id, String value, FormMO form, List<QuestionOptionMO> options) {
        super(id, value, form, options);
    }

}
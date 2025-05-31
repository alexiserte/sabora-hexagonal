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
public class UniqueAnswerQuestionMO extends QuestionMO {

    @Builder
    public UniqueAnswerQuestionMO(int id, String value, FormMO form, List<QuestionOptionMO> options) {
        super(id, value, form, options);
    }

}
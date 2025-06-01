package com.sabora.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
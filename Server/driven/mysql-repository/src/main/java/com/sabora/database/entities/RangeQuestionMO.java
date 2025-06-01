package com.sabora.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seleccion_intervalo")
@PrimaryKeyJoinColumn(name = "id_pregunta")
public class RangeQuestionMO extends QuestionMO {

    @Min(0)
    @Column(name = "min", nullable = false)
    private int min;

    @Column(name = "max", nullable = false)
    private int max;

    @Min(0)
    @Column(name = "intervalo", nullable = false)
    private int interval;

    @Builder
    public RangeQuestionMO(int id, String value, FormMO form, int min, int max, int interval) {
        super(id, value, form, null);
        this.min = min;
        this.max = max;
        this.interval = interval;
    }

}
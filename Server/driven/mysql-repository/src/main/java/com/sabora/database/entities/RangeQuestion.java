package com.sabora.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seleccion_intervalo")
@PrimaryKeyJoinColumn(name = "id_pregunta")
public class RangeQuestion extends Question{

    @Min(0)
    @Column(name="min", nullable=false)
    private int min;

    @Column(name="max", nullable=false)
    private int max;

    @Min(0)
    @Column(name="intervalo", nullable=false)
    private int interval;

    @Builder
    public RangeQuestion(int id, String value, Form form, int min, int max, int interval) {
        super(id, value, form, null);
        this.min = min;
        this.max = max;
        this.interval = interval;
    }

}
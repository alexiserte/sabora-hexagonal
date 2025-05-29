package com.sabora.application.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RangeQuestion extends Question{

    private int min;
    private int max;
    private int interval;
    @Builder
    public RangeQuestion(int id, String value, Form form, int min, int max, int interval) {
        super(id, value, form, null);
        this.min = min;
        this.max = max;
        this.interval = interval;
    }

}
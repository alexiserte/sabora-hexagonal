package com.sabora.application.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    private int id;
    private String name;
    private String composition;
    private BigDecimal fats;
    private BigDecimal carbohydrates;
    private BigDecimal proteins;
    private BigDecimal salt;
    private BigDecimal calories;

}

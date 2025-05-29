package com.sabora.application.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    private Integer id;
    private Date date;
    private String name;
    private FoodSpecialist author;

}

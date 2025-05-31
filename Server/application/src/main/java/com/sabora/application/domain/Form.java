package com.sabora.application.domain;

import lombok.*;

import java.sql.Date;
import java.util.List;

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
    private List<Question> questions;

}

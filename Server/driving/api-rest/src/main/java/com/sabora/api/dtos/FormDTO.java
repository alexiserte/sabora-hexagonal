package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FormDTO {

    private Integer id;
    private String name;
    private String foodSpecialist;
    private Date creationDate;
    private List<QuestionDTO> questions;
}

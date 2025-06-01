package com.sabora.api.dtos;

import lombok.*;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FormDTO {

    private Integer id;
    private String name;
    private String foodSpecialist;
    private Date creationDate;
    private List<QuestionDTO> questions;
}

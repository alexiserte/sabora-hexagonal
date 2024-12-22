package com.sabora.server.DTOs;

import com.sabora.server.Models.FoodSpecialist;
import com.sabora.server.Models.Form;
import com.sabora.server.Repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

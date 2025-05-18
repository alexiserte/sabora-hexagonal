package com.sabora.server.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormAnswerDTO {
    private int formId;
    private int experienceId;
    private String userIdentifier;
    private List<AnswerDTO> answers;
}
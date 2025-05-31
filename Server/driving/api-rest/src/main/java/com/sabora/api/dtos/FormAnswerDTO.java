package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormAnswerDTO {
    private int formId;
    private int experienceId;
    private String userIdentifier;
    private List<AnswerDTO> answers;
}
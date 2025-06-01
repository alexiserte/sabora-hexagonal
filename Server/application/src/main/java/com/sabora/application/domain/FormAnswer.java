package com.sabora.application.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class FormAnswer {
    private int formId;
    private int experienceId;
    private String userIdentifier;
    private List<Answer> answers;
}

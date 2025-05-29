package com.sabora.application.ports.driving;

import com.sabora.server.DTOs.AnswerDTO;
import com.sabora.server.DTOs.FormAnswerDTO;

import java.util.List;

public interface FormAnswerServices {
    void answerForm(FormAnswerDTO formAnswerDTO);
    List<AnswerDTO> getFormAnswers(int formId);
    List<AnswerDTO> getAnswersToAQuestion(int questionId);
}
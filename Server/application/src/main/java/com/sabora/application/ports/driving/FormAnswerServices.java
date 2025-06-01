package com.sabora.application.ports.driving;

import com.sabora.application.domain.Answer;
import com.sabora.application.domain.FormAnswer;

import java.util.List;

public interface FormAnswerServices {
    void answerForm(FormAnswer formAnswer);
    List<Answer> getFormAnswers(Integer formId);
    List<Answer> getAnswersToAQuestion(Integer questionId);
}
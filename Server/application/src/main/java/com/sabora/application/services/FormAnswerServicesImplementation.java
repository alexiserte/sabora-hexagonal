package com.sabora.application.services;

import com.sabora.application.domain.Answer;
import com.sabora.application.domain.Experience;
import com.sabora.application.domain.FormAnswer;
import com.sabora.application.domain.Question;
import com.sabora.application.ports.driven.AnswerRepositoryPort;
import com.sabora.application.ports.driven.ExperienceRepositoryPort;
import com.sabora.application.ports.driven.QuestionRepositoryPort;
import com.sabora.application.ports.driving.FormAnswerServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FormAnswerServicesImplementation implements FormAnswerServices {

    private AnswerRepositoryPort answerRepository;
    private QuestionRepositoryPort questionRepository;
    private ExperienceRepositoryPort experienceRepository;


    @Override
    public void answerForm(FormAnswer formAnswer) {
        for (Answer answer : formAnswer.getAnswers()) {
            Question question = questionRepository.findById(answer.getQuestion().getId());
            answer.setQuestion(question);

            Experience experience = experienceRepository.findById(answer.getExperience().getId());
            answer.setExperience(experience);
            answerRepository.save(answer);
        }
    }

    @Override
    public List<Answer> getFormAnswers(Integer formId) {
        List<Question> questions = questionRepository.findByFormId(formId);
        List<Answer> res = new ArrayList<>();

        for (Question question : questions) {
            answerRepository.findByQuestionId(question.getId()).forEach(answer -> res.add(answer));
        }
        return res;
    }

    @Override
    public List<Answer> getAnswersToAQuestion(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }


}

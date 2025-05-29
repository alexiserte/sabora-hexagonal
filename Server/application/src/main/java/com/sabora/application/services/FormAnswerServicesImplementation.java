package com.sabora.application.services;

import com.sabora.server.DTOs.AnswerDTO;
import com.sabora.server.DTOs.FormAnswerDTO;
import com.sabora.server.Entities.*;
import com.sabora.server.Repositories.AnswerRepository;
import com.sabora.server.Repositories.ExperienceRepository;
import com.sabora.server.Repositories.QuestionRepository;
import com.sabora.server.Repositories.UserRepository;
import com.sabora.server.Services.FormAnswerServices;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormAnswerServicesImplementation implements FormAnswerServices {

    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private ExperienceRepository experienceRepository;

    public FormAnswerServicesImplementation(AnswerRepository answerRepository, QuestionRepository questionRepository, UserRepository userRepository, ExperienceRepository experienceRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.experienceRepository = experienceRepository;
    }

    @Override
    public void answerForm(FormAnswerDTO formAnswerDTO) {
        List<AnswerDTO> formAnswers = formAnswerDTO.getAnswers();
        for (AnswerDTO answer : formAnswers) {
            Answer answerEntity = new Answer();

            Question question = questionRepository.findById(answer.getQuestionId());
            answerEntity.setQuestion(question);
            answerEntity.setAuthor(formAnswerDTO.getUserIdentifier());

            answerEntity.setValue(answer.getAnswer());


            Experience experience = experienceRepository.findById(formAnswerDTO.getExperienceId());
            answerEntity.setExperience(experience);
            answerEntity.setAnswerTimeStamp(LocalDateTime.now());
            answerRepository.save(answerEntity);
        }
    }

    @Override
    public List<AnswerDTO> getFormAnswers(int formId) {
        List<Question> questions = questionRepository.findByFormId(formId);
        List<AnswerDTO> res = new ArrayList<>();

        for (Question question : questions) {
            List<Answer> answers = answerRepository.findByQuestionId(question.getId());
            for (Answer answer : answers) {
                AnswerDTO answerDTO = new AnswerDTO();
                answerDTO.setId(answer.getId());
                answerDTO.setQuestionId(answer.getQuestion().getId());
                answerDTO.setAnswer(answer.getValue());
                res.add(answerDTO);
            }
        }
        return res;
    }

    @Override
    public List<AnswerDTO> getAnswersToAQuestion(int questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);
        List<AnswerDTO> res = new ArrayList<>();
        for (Answer answer : answers) {
            AnswerDTO answerDTO = new AnswerDTO();
            answerDTO.setId(answer.getId());
            answerDTO.setQuestionId(answer.getQuestion().getId());
            answerDTO.setAnswer(answer.getValue());
            res.add(answerDTO);
        }
        return res;
    }


}

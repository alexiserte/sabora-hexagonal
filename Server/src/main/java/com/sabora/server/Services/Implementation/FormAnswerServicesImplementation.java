package com.sabora.server.Services.Implementation;

import com.sabora.server.DTOs.AnswerDTO;
import com.sabora.server.DTOs.FormAnswerDTO;
import com.sabora.server.Models.*;
import com.sabora.server.Repositories.AnswerRepository;
import com.sabora.server.Repositories.ExperienceRepository;
import com.sabora.server.Repositories.QuestionRepository;
import com.sabora.server.Repositories.UserRepository;
import com.sabora.server.Services.FormAnswerServices;

import java.util.List;

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

            User user = userRepository.findByDni(formAnswerDTO.getUserDni());
            answerEntity.setAuthor((GlassesUser) user);

            answerEntity.setValue(answer.getAnswer());

            Experience experience = experienceRepository.findById(formAnswerDTO.getExperienceId());
            answerEntity.setExperience(experience);

            answerRepository.save(answerEntity);
        }


    }

}

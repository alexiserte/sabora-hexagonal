package com.sabora.application.services;

import com.sabora.application.config.EncryptionConfig;
import com.sabora.application.domain.FoodSpecialist;
import com.sabora.application.domain.Form;
import com.sabora.application.domain.Question;
import com.sabora.application.domain.QuestionOption;
import com.sabora.application.ports.driven.*;
import com.sabora.application.ports.driving.FormServices;
import com.sabora.application.Encryption.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class FormServicesImplementation implements FormServices {

    private FormRepositoryPort formRepository;
    private QuestionRepositoryPort questionRepository;
    private AnswerRepositoryPort answerRepository;
    private QuestionOptionRepositoryPort questionOptionRepository;
    private UserRepositoryPort userRepository;
    private EncryptionConfig encryptionConfig;

    @Override
    public Form createFormDTO(Form form) {
        try {
            int formId = form.getId();
            String formName = form.getName();
            String authorUsername = DataEncryption.decrypt(form.getAuthor().getDni(), encryptionConfig.getSecretKey());
            Date creationDate = form.getDate();
            List<Question> questions = questionRepository.findByFormId(formId);
            return Form.builder()
                    .id(formId)
                    .name(formName)
                    .author((FoodSpecialist) userRepository.findByDni(DataEncryption.encrypt(authorUsername, encryptionConfig.getSecretKey())))
                    .date(creationDate)
                    .questions(questions)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    @Override
    public void saveForm(Form form) {

        try {
            String dniEncrypted = DataEncryption.encrypt(form.getAuthor().getDni(), encryptionConfig.getSecretKey());
            form.setAuthor((FoodSpecialist) userRepository.findByDni(dniEncrypted));
            form = formRepository.save(form);

            for (Question question : form.getQuestions()) {
                question.setForm(form);
                questionRepository.save(question);
                List<QuestionOption> options = question.getOptions();
                for (QuestionOption option : options) {
                    option.setQuestion(question);
                    questionOptionRepository.save(option);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Form getFormById(Integer id) {
        return formRepository.findById(Long.valueOf(id));
    }

    @Override
    public void deleteForm(Integer id) {
        formRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Form getFormByName(String name) {
        return formRepository.findByName(name);
    }

}

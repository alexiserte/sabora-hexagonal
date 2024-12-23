package com.sabora.server.Services.Implementation;

import com.sabora.server.Configuration.EncryptionConfig;
import com.sabora.server.DTOs.*;
import com.sabora.server.Models.*;
import com.sabora.server.Repositories.*;
import com.sabora.server.Services.FormServices;
import com.sabora.server.Utils.Encryption.DataEncryption;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FormServicesImplementation implements FormServices {

    private FormRepository formRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private QuestionOptionRepository questionOptionRepository;
    private QuestionServicesImplementation questionServices;
    private UserRepository userRepository;
    private EncryptionConfig encryptionConfig;


    public FormServicesImplementation(FormRepository formRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, QuestionOptionRepository questionOptionRepository, QuestionServicesImplementation questionServices, UserRepository userRepository, EncryptionConfig encryptionConfig) {
        this.formRepository = formRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.questionOptionRepository = questionOptionRepository;
        this.questionServices = questionServices;
        this.userRepository = userRepository;
        this.encryptionConfig = encryptionConfig;
    }

    public FormDTO createFormDTO(Form form) {
        try {
            int formId = form.getId();
            String formName = form.getName();
            String authorUsername = DataEncryption.decrypt(form.getAuthor().getDni(), encryptionConfig.getSecretKey());
            Date creationDate = form.getDate();

            List<QuestionDTO> questionsDTO = new ArrayList<>();
            List<Question> questions = questionRepository.findByFormId(formId);
            for (Question question : questions) {
                questionsDTO.add(questionServices.mapToQuestionDTO(question));
            }
            return new FormDTO(formId, formName, authorUsername, creationDate, questionsDTO);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public void saveForm(FormDTO formDTO) {

        try {
            Form form = new Form();

            String dniEncrypted = DataEncryption.encrypt(formDTO.getFoodSpecialist(),encryptionConfig.getSecretKey());
            form.setAuthor((FoodSpecialist) userRepository.findByDni(dniEncrypted));
            form.setName(formDTO.getName());
            form.setDate(formDTO.getCreationDate());

            form = formRepository.save(form);

            for(QuestionDTO questionDTO : formDTO.getQuestions()) {
                Question question = questionServices.questionDTOToQuestion(questionDTO);
                question.setForm(form);
                questionRepository.save(question);
                List<QuestionOption> options = question.getOptions();
                for(QuestionOption option : options) {
                    option.setQuestion(question);
                    questionOptionRepository.save(option);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Form getFormById(int id) {
        Optional<Form> forms = formRepository.findById(Long.valueOf(id));
        if(forms.isPresent()) {
            return forms.get();
        }
        return null;
    }

    public void deleteForm(int id) {
        formRepository.deleteById(Long.valueOf(id));
    }


}

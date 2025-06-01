package com.sabora.api.adapters;


import com.sabora.api.mappers.AnswerDTOMapper;
import com.sabora.api.mappers.FormAnswerDTOMapper;
import com.sabora.application.ports.driving.FormAnswerServices;
import lombok.AllArgsConstructor;
import org.openapitools.api.AnswerFormApi;
import org.openapitools.model.AnswerDTO;
import org.openapitools.model.FormAnswerDTO;
import org.openapitools.model.SimpleMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
public class AnswerController implements AnswerFormApi {

    private final FormAnswerServices formAnswerServices;
    private final FormAnswerDTOMapper formAnswerDTOMapper;
    private final AnswerDTOMapper answerDTOMapper;
    private static final Logger log = Logger.getLogger(AnswerController.class.getName());

    @Override
    public ResponseEntity<SimpleMessageDTO> answerForm(String id, FormAnswerDTO formAnswerDTO) {
        try {
            log.info("Answering form with id: " + id);
            formAnswerServices.answerForm(formAnswerDTOMapper.toDomain(formAnswerDTO));
            return ResponseEntity.ok(new SimpleMessageDTO("Form answered successfully"));
        } catch (Exception e) {
            log.severe("Error answering form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<AnswerDTO>> getFormAnswers(String id) {
        try {
            log.info("Getting answers to form with id: " + id);
            var formAnswers = formAnswerServices.getFormAnswers(Integer.parseInt(id));
            return ResponseEntity.ok(answerDTOMapper.toDTOAnswers(formAnswers));
        } catch (Exception e) {
            log.severe("Error getting answers to form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<List<AnswerDTO>> getAnswersToAQuestion(String id, Integer questionId) {
        try {
            log.info("Getting answers to question with id: " + questionId + " from form with id: " + id);
            return ResponseEntity.ok(answerDTOMapper.toDTOAnswers(formAnswerServices.getAnswersToAQuestion(questionId)));
        } catch (Exception e) {
            log.severe("Error getting answers to question with id: " + questionId + " from form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}

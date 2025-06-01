package com.sabora.api.adapters;


import com.sabora.api.dtos.FormAnswerDTO;
import com.sabora.api.dtos.SimpleMessageDTO;
import com.sabora.api.mappers.AnswerDTOMapper;
import com.sabora.api.mappers.FormAnswerDTOMapper;
import com.sabora.application.ports.driving.FormAnswerServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@AllArgsConstructor
public class AnswerController {

    private FormAnswerServices formAnswerServices;
    private FormAnswerDTOMapper formAnswerDTOMapper;
    private AnswerDTOMapper answerDTOMapper;
    private static final Logger log = Logger.getLogger(AnswerController.class.getName());

    @PostMapping("/form/{id}/answer")
    public ResponseEntity<SimpleMessageDTO> answerForm(@PathVariable String id, @RequestBody FormAnswerDTO formAnswerDTO) {
        try {
            log.info("Answering form with id: " + id);
            formAnswerServices.answerForm(formAnswerDTOMapper.toDomain(formAnswerDTO));
            return ResponseEntity.ok(SimpleMessageDTO.builder()
                    .message("Form answered successfully")
                    .build());
        } catch (Exception e) {
            log.severe("Error answering form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/form/{id}/answers")
    public ResponseEntity<?> getFormAnswers(@PathVariable String id) {
        try{
            log.info("Getting answers to form with id: " + id);
            return ResponseEntity.ok(formAnswerServices.getFormAnswers(Integer.parseInt(id)));
        } catch (Exception e) {
            log.severe("Error getting answers to form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/form/{id}/question/{questionId}/answers")
    public ResponseEntity<?> getAnswersToAQuestion(@PathVariable String id, @PathVariable String questionId) {
        try{
            log.info("Getting answers to question with id: " + questionId + " from form with id: " + id);
            return ResponseEntity.ok(answerDTOMapper.toDTOAnswers(formAnswerServices.getAnswersToAQuestion(Integer.parseInt(questionId))));
        } catch (Exception e) {
            log.severe("Error getting answers to question with id: " + questionId + " from form with id: " + id);
            log.severe(e.getMessage());
            return ResponseEntity.internalServerError().build();

        }
    }
}

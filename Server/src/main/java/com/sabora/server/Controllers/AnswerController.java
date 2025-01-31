package com.sabora.server.Controllers;

import com.sabora.server.DTOs.FormAnswerDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {

    @PostMapping("/form/{id}/answer")
    public String answerForm(@PathVariable String id, @RequestBody FormAnswerDTO formAnswerDTO) {
        return "Formulario respondido";
    }
}

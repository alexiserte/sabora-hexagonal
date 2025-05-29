package com.sabora.application.ports.driving;

import com.sabora.server.DTOs.QuestionDTO;
import com.sabora.server.Entities.Question;

public interface QuestionService {
     Question questionDTOToQuestion(QuestionDTO questionDTO);
}

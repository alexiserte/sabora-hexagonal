package com.sabora.application.ports.driven;

import com.sabora.application.domain.Answer;

import java.util.List;

public interface AnswerRepositoryPort {
    Answer save(Answer answer);

    List<Answer> findByQuestionId(Integer questionId);
}

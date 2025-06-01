package com.sabora.application.ports.driven;

import com.sabora.application.domain.QuestionOption;

import java.util.List;

public interface QuestionOptionRepositoryPort {
    QuestionOption save(QuestionOption questionOption);

    List<QuestionOption> findByQuestionId(int id);
}

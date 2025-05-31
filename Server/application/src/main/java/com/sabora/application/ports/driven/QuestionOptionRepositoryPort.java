package com.sabora.application.ports.driven;

import com.sabora.application.domain.QuestionOption;

public interface QuestionOptionRepositoryPort {
    QuestionOption save(QuestionOption questionOption);
}

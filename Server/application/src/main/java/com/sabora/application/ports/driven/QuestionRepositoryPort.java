package com.sabora.application.ports.driven;

import com.sabora.application.domain.Question;

import java.util.List;

public interface QuestionRepositoryPort {
    Question findById(Integer id);

    List<Question> findByFormId(Integer formId);

    Question save(Question question);
}

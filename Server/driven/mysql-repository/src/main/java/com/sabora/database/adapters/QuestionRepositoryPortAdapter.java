package com.sabora.database.adapters;

import com.sabora.application.domain.Question;
import com.sabora.application.ports.driven.QuestionRepositoryPort;
import com.sabora.database.mappers.QuestionEntityMapper;
import com.sabora.database.repositories.QuestionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class QuestionRepositoryPortAdapter implements QuestionRepositoryPort {

    private QuestionJpaRepository questionJpaRepository;
    private QuestionEntityMapper questionEntityMapper;

    @Override
    public Question findById(Integer id) {
        return questionEntityMapper.toDomain(
                questionJpaRepository.findById(id)
        );
    }

    @Override
    public List<Question> findByFormId(Integer formId) {
        return questionJpaRepository.findByFormId(formId)
                .stream()
                .map(questionEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Question save(Question question) {
        return questionEntityMapper.toDomain(
                questionJpaRepository.save(questionEntityMapper.toEntity(question))
        );
    }
}

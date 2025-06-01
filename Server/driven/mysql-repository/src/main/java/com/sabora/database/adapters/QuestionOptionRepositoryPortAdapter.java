package com.sabora.database.adapters;

import com.sabora.application.domain.QuestionOption;
import com.sabora.application.ports.driven.QuestionOptionRepositoryPort;
import com.sabora.database.mappers.QuestionOptionEntityMapper;
import com.sabora.database.repositories.QuestionOptionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class QuestionOptionRepositoryPortAdapter implements QuestionOptionRepositoryPort {

    private QuestionOptionJpaRepository questionOptionJpaRepository;
    private QuestionOptionEntityMapper optionEntityMapper;

    @Override
    public QuestionOption save(QuestionOption questionOption) {
        return optionEntityMapper
                .toDomain(questionOptionJpaRepository.save(optionEntityMapper.toEntity(questionOption)));
    }

    @Override
    public List<QuestionOption> findByQuestionId(int id) {
        return questionOptionJpaRepository.findByQuestionId(id)
                .stream()
                .map(optionEntityMapper::toDomain)
                .toList();
    }
}

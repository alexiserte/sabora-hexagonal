package com.sabora.database.adapters;

import com.sabora.application.domain.Answer;
import com.sabora.application.ports.driven.AnswerRepositoryPort;
import com.sabora.database.mappers.AnswerEntityMapper;
import com.sabora.database.repositories.AnswerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AnswerRepositoryPortAdapter implements AnswerRepositoryPort {

    AnswerJpaRepository answerJpaRepository;

    AnswerEntityMapper mapper;

    @Override
    public Answer save(Answer answer) {
        return mapper.toDomain(answerJpaRepository.save(mapper.toEntity(answer)));
    }

    @Override
    public List<Answer> findByQuestionId(Integer questionId) {
        if (questionId == null) {
            return List.of();
        }
        return answerJpaRepository.findByQuestionId(questionId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }
}

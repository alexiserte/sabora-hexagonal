package com.sabora.database.adapters;

import com.sabora.application.domain.Question;
import com.sabora.application.ports.driven.QuestionRepositoryPort;
import com.sabora.database.entities.QuestionMO;
import com.sabora.database.mappers.QuestionEntityMapper;
import com.sabora.database.repositories.QuestionJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class QuestionRepositoryPortAdapter implements QuestionRepositoryPort {

    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionEntityMapper questionEntityMapper;

    @Override
    public Question findById(Integer id) {
        return questionEntityMapper.mapPolymorphicToDomain(questionJpaRepository.findById(id));
    }

    @Override
    public List<Question> findByFormId(Integer formId) {
        List<com.sabora.database.entities.QuestionMO> entities = questionJpaRepository.findByFormId(formId);
        return entities.stream()
                .map(questionEntityMapper::mapPolymorphicToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Question save(Question question) {
        com.sabora.database.entities.QuestionMO entity = questionEntityMapper.mapPolymorphicToEntity(question);
        com.sabora.database.entities.QuestionMO savedEntity = questionJpaRepository.save(entity);
        return questionEntityMapper.mapPolymorphicToDomain(savedEntity);
    }
}

package com.sabora.database.repositories;

import com.sabora.database.entities.AnswerWritingQuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerWritingQuestionJpaRepository extends JpaRepository<AnswerWritingQuestionMO, Long> {
}

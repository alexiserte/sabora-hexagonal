package com.sabora.database.repositories;

import com.sabora.database.entities.MultipleAnswerQuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleAnswerQuestionJpaRepository extends JpaRepository<MultipleAnswerQuestionMO, Long> {
}

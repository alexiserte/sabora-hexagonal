package com.sabora.database.repositories;

import com.sabora.server.Entities.MultipleAnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleAnswerQuestionRepository extends JpaRepository<MultipleAnswerQuestion, Long> {
}

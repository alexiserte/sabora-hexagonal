package com.sabora.database.repositories;

import com.sabora.server.Entities.AnswerWritingQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerWritingQuestionRepository extends JpaRepository<AnswerWritingQuestion, Long> {
}

package com.sabora.database.repositories;

import com.sabora.server.Entities.UniqueAnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueAnswerQuestionRepository extends JpaRepository<UniqueAnswerQuestion, Long> {
}

package com.sabora.server.Repositories;

import com.sabora.server.Entities.UniqueAnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniqueAnswerQuestionRepository extends JpaRepository<UniqueAnswerQuestion, Long> {
}

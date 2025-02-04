package com.sabora.server.Repositories;

import com.sabora.server.Entities.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
    List<QuestionOption> findByQuestionId(int questionId);
}

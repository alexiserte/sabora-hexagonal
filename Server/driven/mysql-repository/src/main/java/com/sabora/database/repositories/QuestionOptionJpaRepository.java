package com.sabora.database.repositories;

import com.sabora.database.entities.QuestionOptionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionOptionJpaRepository extends JpaRepository<QuestionOptionMO, Long> {
    List<QuestionOptionMO> findByQuestionId(int questionId);
}

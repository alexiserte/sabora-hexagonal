package com.sabora.database.repositories;

import com.sabora.database.entities.AnswerMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerJpaRepository extends JpaRepository<AnswerMO, Long> {
    List<AnswerMO> findByQuestionId(int questionId);
}

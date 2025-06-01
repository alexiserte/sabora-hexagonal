package com.sabora.database.repositories;

import com.sabora.database.entities.UniqueAnswerQuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueAnswerQuestionJpaRepository extends JpaRepository<UniqueAnswerQuestionMO, Long> {
}

package com.sabora.database.repositories;

import com.sabora.database.entities.QuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionMO, Long> {
    List<QuestionMO> findByFormId(int formId);
    QuestionMO findById(int id);
}

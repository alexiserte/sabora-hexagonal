package com.sabora.server.Repositories;

import com.sabora.server.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByFormId(int formId);
    Question findById(int id);
}

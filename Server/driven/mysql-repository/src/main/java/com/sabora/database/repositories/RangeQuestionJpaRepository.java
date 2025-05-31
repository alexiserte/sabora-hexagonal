package com.sabora.database.repositories;

import com.sabora.database.entities.RangeQuestionMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RangeQuestionJpaRepository extends JpaRepository<RangeQuestionMO, Long> {
}

package com.sabora.database.repositories;

import com.sabora.database.entities.DataAnalystMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalystJpaRepository extends JpaRepository<DataAnalystMO, Long> {
}

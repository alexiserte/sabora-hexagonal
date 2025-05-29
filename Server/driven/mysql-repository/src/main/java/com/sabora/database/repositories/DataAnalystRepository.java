package com.sabora.database.repositories;

import com.sabora.server.Entities.DataAnalyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataAnalystRepository  extends JpaRepository<DataAnalyst, Long> {
}

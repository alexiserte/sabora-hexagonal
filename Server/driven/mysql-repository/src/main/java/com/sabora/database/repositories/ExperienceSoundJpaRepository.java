package com.sabora.database.repositories;

import com.sabora.database.entities.ExperienceSoundMO;
import com.sabora.database.entities.keys.ExperienceSoundID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceSoundJpaRepository extends JpaRepository<ExperienceSoundMO, ExperienceSoundID> {
}

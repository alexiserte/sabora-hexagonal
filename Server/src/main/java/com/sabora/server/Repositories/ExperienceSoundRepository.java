package com.sabora.server.Repositories;

import com.sabora.server.Entities.ExperienceSound;
import com.sabora.server.Entities.ExperienceSoundID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceSoundRepository extends JpaRepository<ExperienceSound, ExperienceSoundID> {
}

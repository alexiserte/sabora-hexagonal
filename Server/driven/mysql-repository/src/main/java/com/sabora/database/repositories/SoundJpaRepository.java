package com.sabora.database.repositories;

import com.sabora.database.entities.SoundMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundJpaRepository extends JpaRepository<SoundMO, Integer>
{
    SoundMO findByName(String name);
}

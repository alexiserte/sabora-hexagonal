package com.sabora.database.repositories;

import com.sabora.database.entities.SoundEffectMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundEffectJpaRepository extends JpaRepository<SoundEffectMO, Integer>
{
}

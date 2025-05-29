package com.sabora.database.repositories;

import com.sabora.server.Entities.SoundEffect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundEffectRepository extends JpaRepository<SoundEffect, Integer>
{
}

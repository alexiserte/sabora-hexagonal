package com.sabora.server.Repositories;

import com.sabora.server.Entities.SoundEffect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundEffectRepository extends JpaRepository<SoundEffect, Integer>
{
}

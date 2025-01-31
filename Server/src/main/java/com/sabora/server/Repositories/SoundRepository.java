package com.sabora.server.Repositories;

import com.sabora.server.Entities.Sound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoundRepository extends JpaRepository<Sound, Integer>
{
}

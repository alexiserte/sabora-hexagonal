package com.sabora.server.Repositories;

import com.sabora.server.Entities.Sound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundRepository extends JpaRepository<Sound, Integer>
{
    Sound findByName(String name);
}

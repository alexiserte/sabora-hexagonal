package com.sabora.database.repositories;


import com.sabora.database.entities.AmbientMusicMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbientMusicJpaRepository extends JpaRepository<AmbientMusicMO, Integer>
{
}

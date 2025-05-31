package com.sabora.database.repositories;

import com.sabora.database.entities.GlassesUserMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlassesUserJpaRepository extends JpaRepository<GlassesUserMO, Long> {
}

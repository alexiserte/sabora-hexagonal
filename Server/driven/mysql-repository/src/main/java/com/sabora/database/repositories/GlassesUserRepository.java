package com.sabora.database.repositories;

import com.sabora.server.Entities.GlassesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlassesUserRepository extends JpaRepository<GlassesUser, Long> {
}

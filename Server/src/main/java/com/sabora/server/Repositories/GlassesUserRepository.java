package com.sabora.server.Repositories;

import com.sabora.server.Entities.GlassesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlassesUserRepository extends JpaRepository<GlassesUser, Long> {
}

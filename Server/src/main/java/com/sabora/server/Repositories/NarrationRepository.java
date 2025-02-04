package com.sabora.server.Repositories;

import com.sabora.server.Entities.Narration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarrationRepository extends JpaRepository<Narration, Integer>
{
}

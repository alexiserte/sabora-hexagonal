package com.sabora.database.repositories;

import com.sabora.database.entities.NarrationMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NarrationJpaRepository extends JpaRepository<NarrationMO, Integer>
{
}

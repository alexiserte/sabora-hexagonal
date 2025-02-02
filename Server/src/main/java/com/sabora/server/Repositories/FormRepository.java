package com.sabora.server.Repositories;

import com.sabora.server.Entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
}

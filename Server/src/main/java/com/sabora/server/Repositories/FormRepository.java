package com.sabora.server.Repositories;

import com.sabora.server.Models.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long> {
    Form findByName(String name);
}

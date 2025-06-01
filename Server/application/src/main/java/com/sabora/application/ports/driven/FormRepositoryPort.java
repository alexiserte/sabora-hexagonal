package com.sabora.application.ports.driven;

import com.sabora.application.domain.Form;

import java.util.List;

public interface FormRepositoryPort {
    List<Form> findAll();

    Form save(Form form);

    Form findById(Long id);

    void deleteById(Long id);

    Form findByName(String name);
}

package com.sabora.database.adapters;

import com.sabora.application.domain.Form;
import com.sabora.application.ports.driven.FormRepositoryPort;
import com.sabora.database.mappers.FormEntityMapper;
import com.sabora.database.repositories.FormJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FormRepositoryPortAdapter implements FormRepositoryPort {

    private FormJpaRepository formJpaRepository;
    private FormEntityMapper formEntityMapper;

    @Override
    public List<Form> findAll() {
        return formJpaRepository.findAll()
                .stream()
                .map(formEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Form save(Form form) {
        return formEntityMapper.toDomain(formJpaRepository.save(formEntityMapper.toEntity(form)));
    }

    @Override
    public Form findById(Long id) {
        return formJpaRepository.findById(id)
                .map(formEntityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        formJpaRepository.deleteById(id);
    }

    @Override
    public Form findByName(String name) {
        return formEntityMapper.toDomain(
                formJpaRepository.findByName(name)
        );
    }
}

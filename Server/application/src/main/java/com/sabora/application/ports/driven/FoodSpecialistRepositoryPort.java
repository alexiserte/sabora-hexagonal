package com.sabora.application.ports.driven;

import com.sabora.application.domain.Cliente;
import com.sabora.application.domain.DataAnalyst;
import com.sabora.application.domain.FoodSpecialist;

import java.util.List;

public interface FoodSpecialistRepositoryPort {
    FoodSpecialist save(FoodSpecialist cliente);
    List<FoodSpecialist> findAll();
}

package com.sabora.application.ports.driven;

import com.sabora.application.domain.Scenario;

public interface ScenarioRepositoryPort {
    Scenario findByName(String name);

    Scenario save(Scenario scenario);
}

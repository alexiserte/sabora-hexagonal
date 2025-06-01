package com.sabora.application.services;

import com.sabora.application.domain.Scenario;
import com.sabora.application.ports.driven.ScenarioRepositoryPort;
import com.sabora.application.ports.driven.SoundRepositoryPort;
import com.sabora.application.ports.driving.ScenarioServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ScenarioServicesImplementation implements ScenarioServices {


    private ScenarioRepositoryPort scenarioRepository;
    private SoundRepositoryPort soundRepository;

    private FileServiceClientServiceImplementation fileServiceClient;

    @Override
    public void createScenario(Scenario scenario, MultipartFile file) {
        scenario.setPhotoPath(fileServiceClient.uploadFile(file));
        scenario.setSound(soundRepository.findByName(scenario.getSound().getName()));
        scenarioRepository.save(scenario);
    }
}

package com.sabora.server.Services.Implementation;

import com.sabora.server.Clients.FileServiceClient;
import com.sabora.server.DTOs.ScenarioDTO;
import com.sabora.server.Entities.Scenario;
import com.sabora.server.Repositories.ScenarioRepository;
import com.sabora.server.Services.ScenarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ScenarioServicesImplementation implements ScenarioServices {
    @Autowired
    private FileServiceClient fileServiceClient;


    private ScenarioRepository scenarioRepository;

    public ScenarioServicesImplementation(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    @Override
    public void createScenario(ScenarioDTO scenarioDTO, MultipartFile file) {
        Scenario scenario = new Scenario();
        scenario.setName(scenarioDTO.getName());
        scenario.setPlace(scenarioDTO.getPlace());
        scenario.setPhotoPath(fileServiceClient.uploadFile(file).getBody());
        scenario.setSound(scenarioDTO.getSound());
    }
}

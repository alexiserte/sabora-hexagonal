package com.sabora.server.Services.Implementation;

import com.sabora.server.Clients.FileServiceClient;
import com.sabora.server.DTOs.ScenarioDTO;
import com.sabora.server.Models.Scenario;
import com.sabora.server.Services.ScenarioServices;
import org.springframework.web.multipart.MultipartFile;

public class ScenarioServicesImplementation implements ScenarioServices {

    private FileServiceClient fileServiceClient;

    public ScenarioServicesImplementation(FileServiceClient fileServiceClient) {
        this.fileServiceClient = fileServiceClient;
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

package com.sabora.api.adapters;

import com.sabora.server.DTOs.ScenarioDTO;
import com.sabora.server.Services.ScenarioServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ScenarioController {

    private ScenarioServices scenarioServices;

    public ScenarioController(ScenarioServices scenarioServices) {
        this.scenarioServices = scenarioServices;
    }

    @PostMapping("/scenario")
    public ResponseEntity<?> createScenario(@RequestBody ScenarioDTO scenarioDTO, MultipartFile file){
        scenarioServices.createScenario(scenarioDTO, file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

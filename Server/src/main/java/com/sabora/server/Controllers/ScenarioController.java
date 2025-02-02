package com.sabora.server.Controllers;

import com.sabora.server.DTOs.ScenarioDTO;
import com.sabora.server.Services.ScenarioServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScenarioController {

    private ScenarioServices scenarioServices;

    public ScenarioController(ScenarioServices scenarioServices) {
        this.scenarioServices = scenarioServices;
    }

    @PostMapping("/scenario")
    public ResponseEntity<?> createScenario(@RequestBody ScenarioDTO scenarioDTO){
        scenarioServices.createScenario(scenarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

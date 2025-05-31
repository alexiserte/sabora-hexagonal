package com.sabora.api.adapters;


import com.sabora.api.dtos.ScenarioDTO;
import com.sabora.api.mappers.ScenarioDTOMapper;
import com.sabora.application.ports.driving.ScenarioServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class ScenarioController {

    private ScenarioServices scenarioServices;
    private ScenarioDTOMapper scenarioDTOMapper;

    @PostMapping("/scenario")
    public ResponseEntity<?> createScenario(@RequestBody ScenarioDTO scenarioDTO, MultipartFile file){
        scenarioServices.createScenario(scenarioDTOMapper.toDomain(scenarioDTO), file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

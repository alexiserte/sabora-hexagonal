package com.sabora.api.adapters;

import com.sabora.api.mappers.ScenarioDTOMapper;
import com.sabora.application.ports.driving.ScenarioServices;
import lombok.AllArgsConstructor;
import org.openapitools.api.ScenarioApi;
import org.openapitools.model.ScenarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
public class ScenarioController implements ScenarioApi {

    private ScenarioServices scenarioServices;
    private ScenarioDTOMapper scenarioDTOMapper;

    @Override
    public ResponseEntity<ScenarioDTO> createScenario(ScenarioDTO scenarioDTO, MultipartFile file){
        scenarioServices.createScenario(scenarioDTOMapper.toDomain(scenarioDTO), file);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

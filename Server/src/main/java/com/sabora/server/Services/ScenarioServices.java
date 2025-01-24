package com.sabora.server.Services;

import com.sabora.server.DTOs.ScenarioDTO;
import org.springframework.web.multipart.MultipartFile;

public interface ScenarioServices {

    void createScenario(ScenarioDTO scenarioDTO, MultipartFile file);
}

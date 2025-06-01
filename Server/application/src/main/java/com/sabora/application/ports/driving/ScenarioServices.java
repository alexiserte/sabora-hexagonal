package com.sabora.application.ports.driving;

import com.sabora.application.domain.Scenario;
import org.springframework.web.multipart.MultipartFile;

public interface ScenarioServices {

    void createScenario(Scenario scenario, MultipartFile file);

}

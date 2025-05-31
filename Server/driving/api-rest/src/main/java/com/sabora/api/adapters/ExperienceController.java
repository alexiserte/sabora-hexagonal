package com.sabora.api.adapters;

import com.sabora.api.dtos.ExperienceDTO;
import com.sabora.api.dtos.SimpleMessageDTO;
import com.sabora.api.mappers.ExperienceDTOMapper;
import com.sabora.application.ports.driving.ExperienceServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@AllArgsConstructor
public class ExperienceController {

    private ExperienceServices experienceServices;
    private ExperienceDTOMapper experienceDTOMapper;


    @PostMapping("/start")
    public ResponseEntity<ExperienceDTO> startExperience(@RequestBody ExperienceDTO experienceDTO) {
        return ResponseEntity.ok(
                experienceDTOMapper.toDTO(
                        experienceServices.addExperience(
                                experienceDTOMapper.toDomain(experienceDTO)
                        )
                )
        );
    }

    @PutMapping("/end")
    public ResponseEntity<SimpleMessageDTO> endExperience(@RequestBody ExperienceDTO experienceDTO) {
        experienceServices.endExperience(experienceDTOMapper.toDomain(experienceDTO));
        return ResponseEntity.ok(
                SimpleMessageDTO.builder()
                        .message("Experience ended successfully")
                        .build()
        );
    }

    @GetMapping("/unfinished/")
    public ResponseEntity<List<ExperienceDTO>> getUnfinishedExperiences(@RequestParam(name = "client") String client) {
        return ResponseEntity.ok(experienceServices.getUnfinishedExperiences(client)
                .stream().map(experienceDTOMapper::toDTO)
                .toList());
    }
}

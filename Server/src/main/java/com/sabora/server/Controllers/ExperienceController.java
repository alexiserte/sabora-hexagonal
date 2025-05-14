package com.sabora.server.Controllers;

import com.sabora.server.DTOs.ExperienceDTO;
import com.sabora.server.Services.ExperienceServices;
import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

   private static final Logger log = LoggerFactory.getLogger(ExperienceController.class);
   private final ExperienceServices experienceServices;


    public ExperienceController(ExperienceServices experienceServices) {
        this.experienceServices = experienceServices;
    }

   @PostMapping("/start")
    public ResponseEntity<?> startExperience(@RequestBody ExperienceDTO experienceDTO) {
     try{
         return ResponseEntity.ok(experienceServices.addExperience(experienceDTO));
        }catch (Exception e){
            log.error("Error starting experience: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
     }
    }

    @PutMapping("/end")
    public ResponseEntity<?> endExperience(@RequestBody ExperienceDTO experienceDTO) {
        try{
            experienceServices.endExperience(experienceDTO);
            return ResponseEntity.ok("Experience ended successfully");
        }catch (Exception e){
            e.printStackTrace();
            log.error("Error ending experience: {}", e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/unfinished/")
    public ResponseEntity<?> getUnfinishedExperiences(@RequestParam(name = "client") String client){
        try{
            return ResponseEntity.ok(experienceServices.getUnfinishedExperiences(client));
        }catch (Exception e){
            log.error("Error getting unfinished experiences: {}", e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
}

package com.sabora.api.adapters;

import com.sabora.api.dtos.FoodDTO;
import com.sabora.api.dtos.SimpleMessageDTO;
import com.sabora.api.mappers.FoodDTOMapper;
import com.sabora.application.ports.driving.FoodService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final FoodDTOMapper foodMapper;
    private static final Logger log = LoggerFactory.getLogger(FoodController.class);


    @GetMapping("")
    public ResponseEntity<?> getFood(@RequestParam(name = "name") String name){
        log.info("Getting food with name: {}", name);
        return ResponseEntity.ok(foodService.getFood(name));
    }

    @GetMapping("s")
    public ResponseEntity<?> getAllFoods(){
        log.info("Getting all foods");
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @PostMapping("")
    public ResponseEntity<?> postFood(@RequestBody FoodDTO foodDTO){
        foodService.addFood(foodMapper.toDomain(foodDTO));
        log.info("Food {} added successfully", foodDTO.getName());
        return new ResponseEntity<>(SimpleMessageDTO.builder().message("Food added successfully").build(), HttpStatus.CREATED);
    }
}

package com.sabora.api.adapters;


import com.sabora.api.mappers.FoodDTOMapper;
import com.sabora.application.ports.driving.FoodService;
import lombok.AllArgsConstructor;
import org.openapitools.api.FoodApi;
import org.openapitools.model.FoodDTO;
import org.openapitools.model.SimpleMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController implements FoodApi {

    private final FoodService foodService;
    private final FoodDTOMapper foodMapper;
    private static final Logger log = LoggerFactory.getLogger(FoodController.class);


    @GetMapping("")
    public ResponseEntity<FoodDTO> getFood(@RequestParam(name = "name") String name){
        log.info("Getting food with name: {}", name);
        return ResponseEntity.ok(foodMapper.toDTO(foodService.getFood(name)));
    }

    @GetMapping("s")
    public ResponseEntity<List<FoodDTO>> getAllFoods(){
        log.info("Getting all foods");
        return ResponseEntity.ok(foodService.getAllFoods().stream().map(foodMapper::toDTO).collect(Collectors.toList()));
    }

    @PostMapping("")
    public ResponseEntity<SimpleMessageDTO> postFood(@RequestBody FoodDTO foodDTO){
        foodService.addFood(foodMapper.toDomain(foodDTO));
        log.info("Food {} added successfully", foodDTO.getName());
        return new ResponseEntity<>(new SimpleMessageDTO("Food added succesfully"), HttpStatus.CREATED);
    }
}

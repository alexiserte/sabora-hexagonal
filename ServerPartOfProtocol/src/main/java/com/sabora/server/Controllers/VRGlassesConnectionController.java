package com.sabora.server.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.Services.ConnectionServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class VRGlassesConnectionController {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(VRGlassesConnectionController.class);

    @Autowired
    ConnectionServices connectionServices;

    @PostMapping("/glasses/add-connection")
    public ResponseEntity addConnection(@RequestBody HashMap<String, ?> body){
        try {
            log.info("Adding connection: {}", body);
            return connectionServices.addVRGlassesConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error creating connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/glasses/remove-connection")
    public ResponseEntity removeConnection(@RequestBody HashMap<String, ?> body){
        try{
            log.info("Removing connection: {}", body);
            return connectionServices.removeVRGlassesConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error removing connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/glasses/search-mobile")
    public ResponseEntity searchMobile(@RequestBody HashMap<String, ?> body){
        try {
            log.info("Searching for mobiles: {}", body);
            return connectionServices.getConnectedMobileDirection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error searching mobiles." + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

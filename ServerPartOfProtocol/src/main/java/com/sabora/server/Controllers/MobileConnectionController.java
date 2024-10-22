package com.sabora.server.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.CurrentConnections;
import com.sabora.server.Services.ConnectionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
public class MobileConnectionController {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ConnectionServices connectionServices;


    @GetMapping("/mobile/search-glasses")
    public ResponseEntity searchGlasses(@RequestBody HashMap<String, ?> body){
        try {
            return connectionServices.getPossibleGlasses(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error searching glasses." + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/mobile/select-glasses")
    public ResponseEntity selectGlasses(@RequestBody HashMap<String, ?> body){
        try{
            return connectionServices.addMobileGlassesConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error selecting glasses.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/mobile/remove-connection")
    public ResponseEntity removeConnection(@RequestBody HashMap<String, ?> body){
        try{
            return connectionServices.removeMobileConnection(mapper.writeValueAsString(body));
        }catch (Exception e){
            return new ResponseEntity("Error removing connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

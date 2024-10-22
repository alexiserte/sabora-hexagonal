package com.sabora.server.Controllers;

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

    @Autowired
    ConnectionServices connectionServices;

    @PostMapping("/mobile/add-connection")
    public ResponseEntity addConnection(@RequestBody HashMap<String, ?> body){
        try {
            connectionServices.addMobileConnection(body.toString());
            return new ResponseEntity("Connection created." + CurrentConnections.currentMobileConnections, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error creating connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mobile/search-glasses")
    public ResponseEntity searchGlasses(@RequestBody HashMap<String, ?> body){
        try {
            return new ResponseEntity(connectionServices.getPossibleGlasses(body.toString()),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error searching glasses.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/mobile/select-glasses")
    public ResponseEntity selectGlasses(@RequestBody HashMap<String, ?> body){
        try{
            connectionServices.addVRGlassesConnection(body.toString());
            return new ResponseEntity("Connection created.",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error selecting glasses.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/mobile/remove-connection")
    public ResponseEntity removeConnection(@RequestBody HashMap<String, ?> body){
        try{
            connectionServices.removeMobileConnection(body.toString());
            return new ResponseEntity("Connection removed.",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity("Error removing connection.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

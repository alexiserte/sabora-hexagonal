package com.sabora.server.Controllers;

import com.sabora.server.Models.ConnectionObject;
import com.sabora.server.Services.Implementation.NewConnectionServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConnectionController {

    @Autowired
    NewConnectionServices connectionServices;

    @PostMapping("/connection")
    public ResponseEntity<?> connection(@RequestBody ConnectionObject object, HttpServletRequest request){
        System.out.println(object.getName());
        System.out.println(object.getLocalIp());
        connectionServices.createConnection(object.getName(),object.getLocalIp(),request.getRemoteAddr());
        return ResponseEntity.ok("Connection created");
    }

    @DeleteMapping("/connection")
    public ResponseEntity<?> removeConnection(@RequestBody ConnectionObject object){
        connectionServices.removeConnection(object.getName());
        return ResponseEntity.ok("Connection removed");
    }

    @GetMapping("/all-connections")
    public ResponseEntity<?> getConnections(){
        return ResponseEntity.ok(connectionServices.getConnections());
    }

    @GetMapping("/connections")
    public ResponseEntity<?> getLocalConnections(HttpServletRequest request){
        return ResponseEntity.ok(connectionServices.getLocalConnection(request.getRemoteAddr()));
    }
}

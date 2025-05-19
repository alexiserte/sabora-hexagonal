package com.sabora.server.Controllers;

import com.sabora.server.Entities.ConnectionObject;
import com.sabora.server.Services.Implementation.NewConnectionServices;
import com.sabora.server.Services.Implementation.TabletConnectionServicesImplementation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TabletConnectionController {


    NewConnectionServices connectionServices;

    public TabletConnectionController(TabletConnectionServicesImplementation connectionServices) {
        this.connectionServices = connectionServices;
    }

    @PostMapping("/tablet/connection")
    public ResponseEntity<?> connection(@RequestBody ConnectionObject object, HttpServletRequest request){
        System.out.println(object.getName());
        System.out.println(object.getLocalIp());
        connectionServices.createConnection(object.getName(),object.getLocalIp(),request.getRemoteAddr());
        return ResponseEntity.ok("Connection created");
    }

    @DeleteMapping("/tablet/connection")
    public ResponseEntity<?> removeConnection(@RequestBody ConnectionObject object){
        connectionServices.removeConnection(object.getName());
        return ResponseEntity.ok("Connection removed");
    }

    @GetMapping("/tablet/all-connections")
    public ResponseEntity<?> getConnections(){
        return ResponseEntity.ok(connectionServices.getConnections());
    }

    @GetMapping("/tablet/connections")
    public ResponseEntity<?> getLocalConnections(HttpServletRequest request){
        return ResponseEntity.ok(connectionServices.getLocalConnection(request.getRemoteAddr()));
    }
}

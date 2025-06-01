package com.sabora.api.adapters;


import com.sabora.api.dtos.ConnectionObjectDTO;
import com.sabora.application.ports.driving.NewConnectionServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ConnectionController {

    private NewConnectionServices connectionServices;


    @PostMapping("/connection")
    public ResponseEntity<?> connection(@RequestBody ConnectionObjectDTO object, HttpServletRequest request){
        System.out.println(object.getName());
        System.out.println(object.getLocalIp());
        connectionServices.createConnection(object.getName(),object.getLocalIp(),request.getRemoteAddr());
        return ResponseEntity.ok("Connection created");
    }

    @DeleteMapping("/connection")
    public ResponseEntity<?> removeConnection(@RequestBody ConnectionObjectDTO object){
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

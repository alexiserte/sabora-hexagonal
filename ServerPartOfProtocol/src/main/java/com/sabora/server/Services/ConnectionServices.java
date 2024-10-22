package com.sabora.server.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.CurrentConnections;
import com.sabora.server.Message;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.sabora.server.CurrentConnections.*;

@Service
public class ConnectionServices {


    public ResponseEntity addVRGlassesConnection(String data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("REGISTER")){return new ResponseEntity("Invalid message type", HttpStatus.BAD_REQUEST);}
            addNewVRGlassesConnection(msg.getUserIP(),msg.getUserID());
        }catch (Exception e){
            return new ResponseEntity("Error creating connection:\n" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Connection created.",HttpStatus.CREATED);
    }

    public ResponseEntity getPossibleGlasses(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("SEARCH")){throw new Exception("Invalid message type");}
            return new ResponseEntity(getGlassesInTheSameNetwork(msg.getUserIP()),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity("Zero glasses found.",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity addMobileGlassesConnection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("CONNECTION")){return new ResponseEntity("Invalid message type", HttpStatus.BAD_REQUEST);}
            registerMobileGlassesConnection(msg.getMessageParameters(),msg.getUserIP());
        }catch (Exception e){
            return new ResponseEntity("Error creating connection:\n" + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Connection created.",HttpStatus.CREATED);
    }

    public ResponseEntity removeMobileConnection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("DISCONNECTION")){return new ResponseEntity("Invalid message type", HttpStatus.BAD_REQUEST);}
            HashMap<String,String> selectedConnection = new HashMap<>();
            removeMobileGlassesConnection(selectedConnection);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity("Connection removed.",HttpStatus.OK);
    }

    public ResponseEntity removeVRGlassesConnection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("DISCONNECTION")){return new ResponseEntity("Invalid message type", HttpStatus.BAD_REQUEST);}
            Pair<String,String> currentGlasses = Pair.of(msg.getUserIP(),msg.getUserID());
            currentVRGlassesConnections.remove(currentGlasses);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity("Connection removed.",HttpStatus.OK);
    }

    public ResponseEntity getConnectedMobileDirection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            if(!msg.getType().equals("CONNECTION")){return new ResponseEntity("Invalid message type", HttpStatus.BAD_REQUEST);}
            return new ResponseEntity(getMobileIP(msg.getUserIP(),msg.getUserID()),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity("No mobile connected.",HttpStatus.NOT_FOUND);
    }

}

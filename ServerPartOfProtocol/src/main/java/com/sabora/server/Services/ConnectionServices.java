package com.sabora.server.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.CurrentConnections;
import com.sabora.server.Message;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.sabora.server.CurrentConnections.*;

@Service
public class ConnectionServices {

    public void addMobileConnection(String data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            addNewMobileConnection(msg.getUserIP(),msg.getUserID());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addVRGlassesConnection(String data) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            addNewVRGlassesConnection(msg.getUserIP(),msg.getUserID());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Map<String,String> getPossibleGlasses(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            return getGlassesInTheSameNetwork(msg.getUserIP());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new HashMap<>();
    }

    public void addMobileGlassesConnection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            registerMobileGlassesConnection(msg.getMessageParameters());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removeMobileConnection(String data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Message msg = mapper.readValue(data, Message.class);
            HashMap<String,String> selectedConnection = new HashMap<>();
            removeMobileGlassesConnection(selectedConnection);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

package com.sabora.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentConnections {
    public static HashMap<String,String> currentMobileConnections = new HashMap<>();
    public static HashMap<Pair<String,String>,String> currentVRGlassesConnections = new HashMap<>();


    public static void addNewMobileConnection(String userIP, String userID){
        currentMobileConnections.put(userIP,userID);
    }
    public static void addNewVRGlassesConnection(String userIP, String userID){
        currentVRGlassesConnections.put(Pair.of(userIP,userID),null);
    }

    public static Map<String, String> getGlassesInTheSameNetwork(String userIP) {
        Map<String, String> res = new HashMap<>();

        for (Pair<String, String> conn : currentVRGlassesConnections.keySet()) {
            String ip = conn.getFirst();
            String[] ipOneSplitted = userIP.split("\\.");
            String[] ipTwoSplitted = ip.split("\\.");

            if (ipOneSplitted.length != ipTwoSplitted.length) {
                continue;
            }

            boolean sameSubnet = true;
            for (int i = 0; i < ipOneSplitted.length - 1; i++) {
                if (!ipOneSplitted[i].equals(ipTwoSplitted[i])) {
                    sameSubnet = false;
                    break;
                }
            }

            if (sameSubnet) {
                res.put(conn.getFirst(), conn.getSecond());
            }
        }

        return res;
    }

    public static void registerMobileGlassesConnection(HashMap<String,String> selectedConnection){
        for(Pair<String, String> conn : currentVRGlassesConnections.keySet()){
            if(selectedConnection.containsKey(conn.getFirst())) {
                currentVRGlassesConnections.put(conn, selectedConnection.get(conn.getFirst()));
            }
        }
    }

    public static String getMobileIP(String glassesIP, String glassesID){
        Pair<String, String> glasses = Pair.of(glassesIP, glassesID);
        for (Pair<String, String> conn : currentVRGlassesConnections.keySet()) {
            if (conn.equals(glasses) && currentVRGlassesConnections.get(conn) != null) {
                return currentVRGlassesConnections.get(conn);
            }
        }
        return null;
    }

    public static void removeMobileGlassesConnection(HashMap<String,String> selectedConnection){
        for(Pair<String, String> conn : currentVRGlassesConnections.keySet()){
            if(selectedConnection.containsKey(conn.getFirst())) {
                currentVRGlassesConnections.put(conn, null);
            }
        }
    }
}

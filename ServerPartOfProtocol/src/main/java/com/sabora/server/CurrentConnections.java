package com.sabora.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurrentConnections {
    public static HashMap<Pair<String,String>,String> currentVRGlassesConnections = new HashMap<>();

    public static void addNewVRGlassesConnection(String userIP, String userID){
        currentVRGlassesConnections.put(Pair.of(userIP,userID),null);
    }

    /**
     * Retrieves a map of VR glasses connections that are in the same network as the given user IP.
     *
     * @param userIP the IP address of the user to find glasses in the same network
     * @return a map where the keys are the IP addresses of the glasses in the same network,
     *         and the values are the corresponding user IDs
     */
    public static Map<String, String> getGlassesInTheSameNetwork(String userIP) {
        Map<String, String> res = new HashMap<>();

        for (Pair<String, String> conn : currentVRGlassesConnections.keySet()) {
            String ip = conn.getFirst();
            if (ip.startsWith(userIP.substring(0, userIP.lastIndexOf(".")))) {
                res.put(ip, conn.getSecond());
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

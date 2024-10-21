package com.sabora.server;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrentConnections {
    public static HashMap<String,String> currentMobileConnections = new HashMap<>();
    public static HashMap<String,String> currentVRGlassesConnections = new HashMap<>();

    public static void addNewPhoneConnections(String userID, String userIP){
        currentMobileConnections.put(userIP,userID);
    }
    public static void addNewVRGlassesConnections(String userID, String userIP){
        currentMobileConnections.put(userIP,userID);
    }

    public static List<Pair<String,String>> getGlassesInTheSameNetwork(String userIP){
        List<Pair<String,String>> res = new ArrayList<>();

        for(String ip : currentVRGlassesConnections.keySet()){
            String[] ipOneSplitted = userIP.split("\\."); String[] ipTwoSplitted = ip.split("\\.");
            if (ipOneSplitted.length != ipTwoSplitted.length) {continue;}
            for(int i = 0; i < ipOneSplitted.length - 1;i++) if(!ipOneSplitted[i].equals(ipTwoSplitted[i])){continue;}

            res.add(Pair.of(ip,currentVRGlassesConnections.get(ip)));

        }
        return res;
    }
}

package com.sabora.application.services;


import com.sabora.application.domain.ConnectionParams;
import com.sabora.application.ports.driving.NewConnectionServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NewConnectionServicesImplementation implements NewConnectionServices {

    protected static List<ConnectionParams> connections = new ArrayList<>();

    public void createConnection(String name, String localIp, String remoteIp){
        // Si existe un elemento en la lista con la misma direccion IP publica y privada se actualiza, si no se añade
        if(connections.size() == 0) {
            connections.add(new ConnectionParams(name,localIp,remoteIp));
        }
        else {
            for (ConnectionParams connection : connections) {
                if (connection.getLocalIp().equals(localIp) && connection.getRemoteIp().equals(remoteIp)) {
                    connection.setName(name);
                    return;
                }
            }
            connections.add(new ConnectionParams(name, localIp, remoteIp));
        }
    }

    public void removeConnection(String name){
        connections.removeIf(connection -> connection.getName().equals(name));
    }

    public List<ConnectionParams> getConnections(){
        return connections;
    }

    public List<ConnectionParams> getLocalConnection(String remoteIP){
        List<ConnectionParams> localConnections = new ArrayList<>();
        for(ConnectionParams connection : connections){
            if(areInTheSameNetwork(connection.getRemoteIp(),remoteIP)){
                localConnections.add(connection);
            }
        }
        return localConnections;
    }

    private boolean areInTheSameNetwork(String ip1, String ip2){
        String[] ip1Parts = ip1.split("\\.");
        String[] ip2Parts = ip2.split("\\.");
        return ip1Parts[0].equals(ip2Parts[0]) && ip1Parts[1].equals(ip2Parts[1]);
    }

}

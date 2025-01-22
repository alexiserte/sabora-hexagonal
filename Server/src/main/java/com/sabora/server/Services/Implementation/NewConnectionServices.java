package com.sabora.server.Services.Implementation;

import com.sabora.server.Models.ConnectionParams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewConnectionServices{

    private static List<ConnectionParams> connections = new ArrayList<>();

    public void createConnection(String name, String localIp, String remoteIp){
        // Si existe un elemento en la lista con la misma direccion IP publica y privada se actualiza, si no se añade
        for(ConnectionParams connection : connections){
            if(connection.getLocalIp().equals(localIp) && connection.getRemoteIp().equals(remoteIp)){
                connection.setName(name);
                return;
            }
        }
        connections.add(new ConnectionParams(name,localIp,remoteIp));
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
            if(connection.getRemoteIp().equals(remoteIP)){
                localConnections.add(connection);
            }
        }
        return localConnections;
    }
}

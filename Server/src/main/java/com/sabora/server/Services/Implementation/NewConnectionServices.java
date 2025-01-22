package com.sabora.server.Services.Implementation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewConnectionServices{

    private static class ConnectionParams{
        private String name;
        private String localIp;
        private String remoteIp;

        public ConnectionParams(String name, String localIp, String remoteIp){
            this.name = name;
            this.localIp = localIp;
            this.remoteIp = remoteIp;
        }

        @Override
        public String toString(){
            return "Name: " + name + " Local IP: " + localIp + " Remote IP: " + remoteIp;
        }
    }

    private static List<ConnectionParams> connections = new ArrayList<>();

    public void createConnection(String name, String localIp, String remoteIp){
        // Si existe un elemento en la lista con la misma direccion IP publica y privada se actualiza, si no se añade
        for(ConnectionParams connection : connections){
            if(connection.localIp.equals(localIp) && connection.remoteIp.equals(remoteIp)){
                connection.name = name;
                return;
            }
        }
        connections.add(new ConnectionParams(name,localIp,remoteIp));
    }

    public void removeConnection(String name){
        connections.removeIf(connection -> connection.name.equals(name));
    }

    public List<ConnectionParams> getConnections(){
        return connections;
    }

    public List<ConnectionParams> getLocalConnection(String remoteIP){
        List<ConnectionParams> localConnections = new ArrayList<>();
        for(ConnectionParams connection : connections){
            if(connection.remoteIp.equals(remoteIP)){
                localConnections.add(connection);
            }
        }
        return localConnections;
    }
}

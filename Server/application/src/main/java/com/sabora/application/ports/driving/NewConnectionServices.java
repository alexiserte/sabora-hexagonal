package com.sabora.application.ports.driving;

import com.sabora.application.domain.ConnectionParams;

import java.util.List;

public interface NewConnectionServices {
    void createConnection(String name, String localIp, String remoteIp);

    void removeConnection(String name);

    List<ConnectionParams> getConnections();

    List<ConnectionParams> getLocalConnection(String remoteIP);
}

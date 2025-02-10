package com.sabora.server.ServicesTest;

import com.sabora.server.Entities.ConnectionParams;
import com.sabora.server.Services.Implementation.NewConnectionServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ConnectionTest {

    private static NewConnectionServices newConnectionServices;

    @BeforeAll
    static void setUp(){
        newConnectionServices = new NewConnectionServices();
    }

    @Test
    void createNotExistingConnectionTest() {
        // Arrange
        String connName = "Test Connection";
        String localIp = "128.128.128.128";
        String remoteIp = "0.0.0.1";

        // Act & Assert
        newConnectionServices.createConnection(connName, localIp, remoteIp);
        List<ConnectionParams> connections = newConnectionServices.getConnections();

        assertFalse(connections.size() == 0);
        assertTrue(connections.size() == 1);

        ConnectionParams connection = connections.get(0);

        assertEquals(connName, connection.getName());
        assertEquals(localIp, connection.getLocalIp());
        assertEquals(remoteIp, connection.getRemoteIp());

    }

    @Test
    void createExistingConnectionTest() {
        // Arrange
        String connName = "Test Connection";
        String localIp = "128.128.128.128";
        String remoteIp = "0.0.0.1";

        String connName2 = "Test Connection 2";

        // Act & Assert
        newConnectionServices.createConnection(connName, localIp, remoteIp);
        newConnectionServices.createConnection(connName2, localIp, remoteIp);
        List<ConnectionParams> connections = newConnectionServices.getConnections();

        assertFalse(connections.size() == 0);
        assertTrue(connections.size() == 1);

        ConnectionParams connection = connections.get(0);

        assertEquals(connName2, connection.getName());
        assertEquals(localIp, connection.getLocalIp());
        assertEquals(remoteIp, connection.getRemoteIp());
    }

    @Test
    void removeConnectionTest() {
        // Arrange
        String connName = "Test Connection";
        String localIp = "128.128.128.128";
        String remoteIp = "0.0.0.1";

        // Act & Assert
        newConnectionServices.createConnection(connName, localIp, remoteIp);
        newConnectionServices.removeConnection(connName);

        List<ConnectionParams> connections = newConnectionServices.getConnections();

        assertTrue(connections.size() == 0);
    }

    @Test
    void getLocalConnectionsWithExistingGlassesTest() {
        // Arrange
        String connName = "Test Connection";
        String localIp = "128.128.128.128";
        String remoteIp = "127.0.0.1";

        //Act & Assert
        newConnectionServices.createConnection(connName, localIp, remoteIp);

        List<ConnectionParams> localConnections = newConnectionServices.getLocalConnection(remoteIp);

        assertFalse(localConnections.size() == 0);
        assertTrue(localConnections.size() == 1);

        ConnectionParams connection = localConnections.get(0);

        assertEquals(connName, connection.getName());
        assertEquals(localIp, connection.getLocalIp());
        assertEquals(remoteIp, connection.getRemoteIp());
    }

    @Test
    void getLocalConnectionsWithoutExistingGlassesTest() {
        // Arrange
        String connName = "Test Connection";
        String localIp = "128.128.128.128";
        String remoteIp = "127.0.0.1";

        //Act
        newConnectionServices.createConnection(connName, localIp, remoteIp);
        List<ConnectionParams> localConnections = newConnectionServices.getLocalConnection("127.0.0.0");

        //Assert
        assertTrue(localConnections.size() == 0);
    }



}

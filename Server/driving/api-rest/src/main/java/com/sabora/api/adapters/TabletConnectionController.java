package com.sabora.api.adapters;

import com.sabora.api.mappers.ConnectionParamsDTOMapper;
import com.sabora.application.services.TabletConnectionServicesImplementation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.openapitools.api.TabletConnectionsApi;
import org.openapitools.model.ConnectionObjectDTO;
import org.openapitools.model.ConnectionParamsDTO;
import org.openapitools.model.SimpleMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class TabletConnectionController implements TabletConnectionsApi {

    TabletConnectionServicesImplementation connectionServices;
    private final ConnectionParamsDTOMapper connectionParamsDTOMapper;
    private HttpServletRequest request;

    @Override
    public ResponseEntity<SimpleMessageDTO> createTabletConnection(ConnectionObjectDTO object) {
        System.out.println(object.getName());
        System.out.println(object.getLocalIp());
        connectionServices.createConnection(object.getName(), object.getLocalIp(), request.getRemoteAddr());
        return ResponseEntity.ok(
                new SimpleMessageDTO("Connection created successfully")
        );
    }

    @Override
    public ResponseEntity<SimpleMessageDTO> removeTabletConnection(ConnectionObjectDTO object) {
        connectionServices.removeConnection(object.getName());
        return ResponseEntity.ok(
                new SimpleMessageDTO("Connection removed successfully")
        );
    }

    @Override
    public ResponseEntity<List<ConnectionParamsDTO>> getAllConnections() {
        return ResponseEntity.ok(connectionServices.getConnections().stream().map(connectionParamsDTOMapper::toDTO).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<ConnectionParamsDTO>> getLocalTabletConnections() {
        return ResponseEntity.ok(connectionServices.getLocalConnection(request.getRemoteAddr()).stream().map(connectionParamsDTOMapper::toDTO).collect(Collectors.toList()));
    }
}


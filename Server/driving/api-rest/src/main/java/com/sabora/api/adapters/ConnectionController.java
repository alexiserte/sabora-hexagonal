package com.sabora.api.adapters;

import com.sabora.api.mappers.ConnectionParamsDTOMapper;
import com.sabora.application.ports.driving.NewConnectionServices;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.openapitools.api.ConnectionApi;
import org.openapitools.model.ConnectionObjectDTO;
import org.openapitools.model.ConnectionParamsDTO;
import org.openapitools.model.SimpleMessageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ConnectionController implements ConnectionApi {

    private final NewConnectionServices connectionServices;
    private HttpServletRequest request;
    private ConnectionParamsDTOMapper connectionParamsDTOMapper;

    @Override
    public ResponseEntity<List<SimpleMessageDTO>> connection(ConnectionObjectDTO object) {
        String remoteIp = request.getRemoteAddr();
        System.out.println(object.getName());
        System.out.println(object.getLocalIp());
        System.out.println("Remote IP: " + remoteIp);

        connectionServices.createConnection(object.getName(), object.getLocalIp(), remoteIp);

        return ResponseEntity.ok(List.of(new SimpleMessageDTO("Connection created")));
    }

    @Override
    public ResponseEntity<List<ConnectionParamsDTO>> getConnections() {
        return ResponseEntity.ok(connectionServices.getConnections()
                .stream()
                .map(connectionParamsDTOMapper::toDTO)
                .toList());
    }

    @Override
    public ResponseEntity<List<ConnectionParamsDTO>> getLocalConnections() {
        return ResponseEntity.ok(connectionServices.getLocalConnection(request.getRemoteAddr())
                .stream()
                .map(connectionParamsDTOMapper::toDTO)
                .collect(Collectors.toList()));
    }
}

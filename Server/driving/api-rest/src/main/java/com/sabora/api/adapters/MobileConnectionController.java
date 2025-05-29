package com.sabora.api.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.CurrentConnections;
import com.sabora.server.Services.ConnectionServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/mobile") // Agrupamos las rutas bajo el mismo prefijo
public class MobileConnectionController {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(MobileConnectionController.class);

    @Autowired
    ConnectionServices connectionServices;

    @GetMapping("/search-glasses")
    @Operation(summary = "Search for available glasses",
            description = "This endpoint searches for available glasses based on the provided criteria.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved glasses"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> searchGlasses(@RequestBody HashMap<String, ?> body) {
        try {
            log.info("Searching for glasses: {}", body);
            return connectionServices.getPossibleGlasses(mapper.writeValueAsString(body));
        } catch (Exception e) {
            return new ResponseEntity<>("Error searching glasses: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/select-glasses")
    @Operation(summary = "Select glasses to connect",
            description = "This endpoint allows the mobile device to select a list of glasses for connection.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully selected glasses"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> selectGlasses(@RequestBody HashMap<String, ?> body) {
        try {
            log.info("Selecting glasses: {}", body);
            return connectionServices.addMobileGlassesConnection(mapper.writeValueAsString(body));
        } catch (Exception e) {
            return new ResponseEntity<>("Error selecting glasses: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remove-connection")
    @Operation(summary = "Remove a connection to glasses",
            description = "This endpoint removes a connection between the mobile device and the selected glasses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully removed connection"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<String> removeConnection(@RequestBody HashMap<String, ?> body) {
        try {
            log.info("Removing connection: {}", body);
            return connectionServices.removeMobileConnection(mapper.writeValueAsString(body));
        } catch (Exception e) {
            return new ResponseEntity<>("Error removing connection: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
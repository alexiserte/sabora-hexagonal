package com.sabora.server.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static com.sabora.server.Utils.FileReader.leerArchivo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BasicControllerTest {

    @Autowired
    private RestTemplate restTemplate;


    private final String BASE_URL = "http://localhost";

    @Test
    void correctLoadMainPage(){
        // Arrange
        String expectedResult = leerArchivo("src/main/java/com/sabora/server/HTMLPages/bienvenida.html");
        // Act
        String result = this.restTemplate.getForObject(BASE_URL + "/",
                String.class);
        // Assert
        assertEquals(expectedResult, result);
    }
}

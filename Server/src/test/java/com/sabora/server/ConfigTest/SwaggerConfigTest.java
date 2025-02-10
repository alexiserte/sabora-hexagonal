package com.sabora.server.ConfigTest;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SwaggerConfigTest {

    @Autowired
    private OpenAPI customOpenAPI;


    @Test
    public void testCustomOpenAPI() {
        // Check that the customOpenAPI bean is not null
        assertNotNull(customOpenAPI);

        // Check that the title of the customOpenAPI bean is "API Sabora"
        assertEquals("API Sabora", customOpenAPI.getInfo().getTitle());

        // Check that the description of the customOpenAPI bean is "Documentación de la API REST de Sabora"
        assertEquals("Documentación de la API REST de Sabora", customOpenAPI.getInfo().getDescription());

        // Check that the version of the customOpenAPI bean is "v0.0.1"
        assertEquals("v0.0.1", customOpenAPI.getInfo().getVersion());

        // Check that the license name of the customOpenAPI bean is "Apache 2.0"
        assertEquals("Apache 2.0", customOpenAPI.getInfo().getLicense().getName());

        // Check that the license URL of the customOpenAPI bean is "http://springdoc.org"
        assertEquals("http://springdoc.org", customOpenAPI.getInfo().getLicense().getUrl());

        // Check that the security scheme name of the customOpenAPI bean is "saboraAuth"
        assertEquals("saboraAuth", customOpenAPI.getComponents().getSecuritySchemes().keySet().iterator().next());

        // Check that the security scheme type of the customOpenAPI bean is "HTTP"
        assertEquals("HTTP", customOpenAPI.getComponents().getSecuritySchemes().get("saboraAuth").getType().toString());

        // Check that the security scheme of the custom
        // OpenAPI bean is "bearer"
        assertEquals("bearer", customOpenAPI.getComponents().getSecuritySchemes().get("saboraAuth").getScheme());

        // Check that the security scheme bearer format of the customOpenAPI bean is "JWT"
        assertEquals("JWT", customOpenAPI.getComponents().getSecuritySchemes().get("saboraAuth").getBearerFormat());
    }
}

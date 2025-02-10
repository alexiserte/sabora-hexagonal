package com.sabora.server.ConfigTest;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class RabbitMQConfigTest {

    @Autowired
    private Queue formularioCreadoQueue;

    @Autowired
    private Queue formularioActualizadoQueue;

    @Test
    public void testRabbitMQConfig() {
        // Check that the queues are not null
        assertNotEquals(formularioActualizadoQueue, null);
        assertNotEquals(formularioCreadoQueue, null);

        // Check that the queues are not the same
        assertNotEquals(formularioCreadoQueue, formularioActualizadoQueue);

        // Check that the names are correct
        assertEquals(formularioCreadoQueue.getName(), "formulario-creado");
        assertEquals(formularioActualizadoQueue.getName(), "nueva-respuesta");

        // Check that the queues are durable
        assertTrue(formularioCreadoQueue.isDurable());
        assertTrue(formularioActualizadoQueue.isDurable());

    }
}

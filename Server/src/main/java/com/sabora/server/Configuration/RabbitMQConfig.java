package com.sabora.server.Configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue formularioCreadoQueue() {
        return new Queue("formulario-creado", true);
    }

    @Bean
    public Queue formularioActualizadoQueue() {
        return new Queue("nueva-respuesta", true);
    }
}
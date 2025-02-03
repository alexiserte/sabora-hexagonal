package com.sabora.server.Services.Implementation;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessageProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessageCreatedForm(String message) {
        rabbitTemplate.convertAndSend("formulario-creado", message);
    }

    public void sendMessageUpdatedForm(String message) {
        rabbitTemplate.convertAndSend("nueva-respuesta", message);
    }
}
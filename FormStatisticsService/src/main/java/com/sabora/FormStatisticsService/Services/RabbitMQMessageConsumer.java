package com.sabora.FormStatisticsService.Services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessageConsumer {

    private FormServices formServices;

    public RabbitMQMessageConsumer(FormServices formServices) {
        this.formServices = formServices;
    }

    @RabbitListener(queues = "formulario-creado")
    public void receiveMessageCreatedForm(String message) {
        formServices.createFormDescription(message);
    }

    @RabbitListener(queues = "nueva-respuesta")
    public void receiveMessageUpdatedForm(String message) {
        formServices.createResponseAnalysis(message);
    }
}

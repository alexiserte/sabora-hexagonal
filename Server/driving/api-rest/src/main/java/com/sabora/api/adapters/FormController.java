package com.sabora.api.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.api.mappers.FormDTOMapper;
import com.sabora.application.ports.driving.FormServices;
import com.sabora.application.services.RabbitMQMessageProducerService;
import lombok.AllArgsConstructor;
import org.openapitools.api.FormApi;
import org.openapitools.model.FormDTO;
import org.openapitools.model.SimpleMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class FormController implements FormApi {

    private final FormServices formService;
    private static final Logger log = LoggerFactory.getLogger(FormController.class);
    private final RabbitMQMessageProducerService rabbitMQMessageProducerService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private FormDTOMapper formDTOMapper;

    @Override
    public ResponseEntity<List<FormDTO>> getForm() {
        List<FormDTO> forms = formService.getAllForms().stream()
                .map(formDTOMapper::toDTO)
                .collect(Collectors.toList());
        if (forms.isEmpty()) {
            log.error("No forms found");
            return ResponseEntity.noContent().build();
        }
        log.info("Getting all forms");
        return ResponseEntity.ok(forms);
    }

    @Override
    public ResponseEntity<FormDTO> getFormById(Integer id) {
        log.info("Getting form with id: {}", id);
        return ResponseEntity.ok(
                formDTOMapper.toDTO(formService.getFormById(id))
        );
    }

    @Override
    public ResponseEntity<SimpleMessageDTO> deleteForm(Integer id) {
        log.info("Deleting form with id: {}", id);
        formService.deleteForm(id);
        return ResponseEntity.ok(
                new SimpleMessageDTO("Form deleted successfully")
        );
    }

    @Override
    public ResponseEntity<SimpleMessageDTO> postForm(FormDTO formDTO) {
        formService.saveForm(formDTOMapper.toDomain(formDTO));
        log.info("Form {} added successfully", formDTO.getName());
        try {
            FormDTO form = formDTOMapper.toDTO(formService.getFormByName(formDTO.getName()));
            log.warn("Sending form with id: {} to RabbitMQ", form.getId());
            rabbitMQMessageProducerService.sendMessageCreatedForm(objectMapper.writeValueAsString(form));
        } catch (Exception e) {
            log.error("Error sending message to RabbitMQ: {}", e.getMessage());
        }
        return ResponseEntity.ok(
                new SimpleMessageDTO("Form added successfully")
        );
    }
}

package com.sabora.api.adapters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.api.dtos.FormDTO;
import com.sabora.api.mappers.FormDTOMapper;
import com.sabora.application.ports.driving.FormServices;
import com.sabora.application.services.RabbitMQMessageProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/form")
@AllArgsConstructor
public class FormController {

    private final FormServices formService;
    private static final Logger log = LoggerFactory.getLogger(FormController.class);
    private final RabbitMQMessageProducerService rabbitMQMessageProducerService;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private FormDTOMapper formDTOMapper;



    @GetMapping("/all")
    @Operation(summary = "Get all forms",
            description = "This endpoint returns all the forms stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forms found"),
            @ApiResponse(responseCode = "204", description = "No forms found")
    })
    public ResponseEntity<List<FormDTO>> getForm() {
        List<FormDTO> forms = formService.getAllForms().stream().map(formDTOMapper::toDTO).collect(Collectors.toList());
        if(forms.isEmpty()) {
            log.error("No forms found");
            return ResponseEntity.noContent().build();
        }
        log.info("Getting all forms");
        return ResponseEntity.ok(forms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormById(@Parameter(description = "ID of the form to be obtained") @PathVariable int id) {
        log.info("Getting form with id: {}", id);
        return ResponseEntity.ok(formService.createFormDTO(formService.getFormById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForm(@Parameter(description = "ID of the form to be deleted") @PathVariable int id) {
        log.info("Deleting form with id: {}", id);
        formService.deleteForm(id);
        return ResponseEntity.ok("Form deleted successfully");
    }


    @PostMapping("")
    public ResponseEntity<?> postForm(@RequestBody FormDTO formDTO) {

        formService.saveForm(formDTOMapper.toDomain(formDTO));
        log.info("Form {} added successfully", formDTO.getName());
        try {
            FormDTO form = formDTOMapper.toDTO(formService.getFormByName(formDTO.getName()));
            log.warn("Sending form with id: {} to RabbitMQ", form.getId());
            rabbitMQMessageProducerService.sendMessageCreatedForm(objectMapper.writeValueAsString(form));
        }catch (Exception e) {
            log.error("Error sending message to RabbitMQ: {}", e.getMessage());
        }
        return ResponseEntity.ok("Form added successfully");
    }
}

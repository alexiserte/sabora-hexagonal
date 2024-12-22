package com.sabora.server.Controllers;

import com.sabora.server.DTOs.FormDTO;
import com.sabora.server.Models.Form;
import com.sabora.server.Services.Implementation.FormServicesImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/form")
public class FormController {

    private final FormServicesImplementation formService;
    private static final Logger log = LoggerFactory.getLogger(FormController.class);

    public FormController(FormServicesImplementation formService) {
        this.formService = formService;
    }


    @GetMapping("/all")
    @Operation(summary = "Get all forms",
            description = "This endpoint returns all the forms stored in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Forms found"),
            @ApiResponse(responseCode = "204", description = "No forms found")
    })
    public ResponseEntity<List<FormDTO>> getForm() {
        List<Form> forms = formService.getAllForms();
        if(forms.isEmpty()) {
            log.error("No forms found");
            return ResponseEntity.noContent().build();
        }
        List<FormDTO> formDTOS = forms.stream()
                .map(formService::createFormDTO)
                .collect(Collectors.toList());
        log.info("Getting all forms");
        return ResponseEntity.ok(formDTOS);
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
    @Operation(summary = "Add a new form",
            description = "This endpoint adds a new form. All the data has to be provided in the request body following the FormDTO structure.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Form added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request, invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<?> postForm(@Parameter(
            description = "Survey details to create a new survey",
            examples = @ExampleObject(value = "{\n" +
                    "  \"id\": 1,\n" +
                    "  \"name\": \"Encuesta de satisfacción\",\n" +
                    "  \"foodSpecialist\": \"John Doe\",\n" +
                    "  \"creationDate\": \"2024-12-22\",\n" +
                    "  \"questions\": [\n" +
                    "    {\n" +
                    "      \"type\": \"RANGE\",\n" +
                    "      \"id\": 101,\n" +
                    "      \"question\": \"¿Qué tan satisfecho estás con nuestro servicio?\",\n" +
                    "      \"min\": 1,\n" +
                    "      \"max\": 10,\n" +
                    "      \"interval\": 1\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"type\": \"MULTIPLE_ANSWER\",\n" +
                    "      \"id\": 102,\n" +
                    "      \"question\": \"¿Qué servicios utilizaste?\",\n" +
                    "      \"options\": [\n" +
                    "        \"Entrega a domicilio\",\n" +
                    "        \"Atención en tienda\",\n" +
                    "        \"Asistencia telefónica\"\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"type\": \"UNIQUE_ANSWER\",\n" +
                    "      \"id\": 103,\n" +
                    "      \"question\": \"¿Recomendarías nuestro servicio?\",\n" +
                    "      \"options\": [\n" +
                    "        \"Sí\",\n" +
                    "        \"No\"\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"type\": \"REDACTION\",\n" +
                    "      \"id\": 104,\n" +
                    "      \"question\": \"Por favor, escribe un comentario sobre tu experiencia.\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}"))
                    @RequestBody FormDTO formDTO) {
        formService.saveForm(formDTO);
        log.info("Form {} added successfully", formDTO.getName());
        return ResponseEntity.ok("Form added successfully");
    }
}

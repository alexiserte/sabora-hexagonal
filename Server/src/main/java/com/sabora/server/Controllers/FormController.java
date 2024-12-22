package com.sabora.server.Controllers;

import com.sabora.server.DTOs.FormDTO;
import com.sabora.server.Models.Form;
import com.sabora.server.Services.Implementation.FormServicesImplementation;
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
    public ResponseEntity<List<FormDTO>> getForm() {
        List<Form> forms = formService.getAllForms();
        List<FormDTO> formDTOS = forms.stream()
                .map(formService::createFormDTO)
                .collect(Collectors.toList());
        log.info("Getting all forms");
        return ResponseEntity.ok(formDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormById(@PathVariable int id) {
        log.info("Getting form with id: {}", id);
        return ResponseEntity.ok(formService.createFormDTO(formService.getFormById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteForm(@PathVariable int id) {
        log.info("Deleting form with id: {}", id);
        formService.deleteForm(id);
        return ResponseEntity.ok("Form deleted successfully");
    }

    @PostMapping("")
    public ResponseEntity<?> postForm(@RequestBody FormDTO formDTO) {
        formService.saveForm(formDTO);
        log.info("Form {} added successfully", formDTO.getName());
        return ResponseEntity.ok("Form added successfully");
    }
}

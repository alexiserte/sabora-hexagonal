package com.sabora.FormStatisticsService.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class WebController {


    @PostMapping("/form")
    public String getFormStatistics(@RequestBody String formId) {
        return "Estadisticas del formulario";
    }
}

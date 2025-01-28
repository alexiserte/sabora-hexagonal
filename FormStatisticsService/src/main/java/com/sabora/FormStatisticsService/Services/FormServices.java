package com.sabora.FormStatisticsService.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.FormStatisticsService.Models.FormDescription;
import com.sabora.FormStatisticsService.Repositories.FormDescriptionRepository;
import org.springframework.stereotype.Service;

import static org.hibernate.Hibernate.map;

@Service
public class FormServices {

    private FormDescriptionRepository formDescriptionRepository;

    public FormServices(FormDescriptionRepository formDescriptionRepository, AIRequestService aiRequestService) {
        this.formDescriptionRepository = formDescriptionRepository;
    }

    private int getFormId(String form) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(form);
            String formId = rootNode.get("id").asText();
            return Integer.parseInt(formId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

   protected void createFormDescription(String form){
        int formId = getFormId(form);
        FormDescription formDescription = new FormDescription();
        formDescription.setId(formId);
        String formDescriptionString = AIRequestService.getAIResponse(form);
        formDescription.setForm_analysis(formDescriptionString);
       formDescriptionRepository.findById(Long.valueOf(Integer.toString(formId)))
               .map(existing -> {
                     existing.setForm_analysis(formDescriptionString);
                   return formDescriptionRepository.save(existing);
               })
               .orElseGet(() -> formDescriptionRepository.save(formDescription));
   }

   protected void createResponseAnalysis(String response){
        int formId = getFormId(response);
        FormDescription formDescription = new FormDescription();
        formDescription.setId(formId);
        String responseAnalysisString = AIRequestService.getAIResponse(response);
        formDescription.setResponse_analysis(responseAnalysisString);
       formDescriptionRepository.findById(Long.valueOf(Integer.toString(formId)))
               .map(existing -> {
                     existing.setResponse_analysis(responseAnalysisString);
                   return formDescriptionRepository.save(existing);
               })
               .orElseGet(() -> formDescriptionRepository.save(formDescription));
   }



}

package com.sabora.FormStatisticsService.Repositories;

import com.sabora.FormStatisticsService.Models.FormDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormDescriptionRepository extends JpaRepository<FormDescription, Long> {
    FormDescription findByFormId(String formId);
}

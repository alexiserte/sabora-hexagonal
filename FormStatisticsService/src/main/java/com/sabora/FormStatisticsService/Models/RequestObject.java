package com.sabora.FormStatisticsService.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestObject {
    private String model;
    private String prompt;
    private boolean stream;

    @Override
    public String toString() {
        return String.format("""
                {
                    "model": "%s",
                    "prompt": "%s",
                    "stream": %b
                }
                """, model, prompt, stream);
    }
}

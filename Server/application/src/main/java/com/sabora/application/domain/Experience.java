package com.sabora.application.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Experience {

    private int id;
    private Long time;
    private Cliente client;
    private Scenario scenario;
    private Sound sound;
    private Food food;
    private List<ExperienceSound> sounds = new ArrayList<>();
}

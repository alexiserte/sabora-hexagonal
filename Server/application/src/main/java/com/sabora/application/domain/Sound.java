package com.sabora.application.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Sound {
    private int id;
    private String name;
    private String filepath;
    private List<ExperienceSound> experiences = new ArrayList<>();
}

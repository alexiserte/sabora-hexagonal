package com.sabora.application.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sound {

    private int id;
    private String name;
    private String filepath;
    private List<ExperienceSound> experiences = new ArrayList<>();

    public Sound(int id, String name, String filepath) {
        this.id = id;
        this.name = name;
        this.filepath = filepath;
    }
}

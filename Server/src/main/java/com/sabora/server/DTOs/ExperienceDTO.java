package com.sabora.server.DTOs;

import com.sabora.server.Entities.ExperienceSound;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDTO {
    private int id;
    private long time;
    private String client;
    private String scenario;
    private String sound;
    private String food;
    private List<String> sounds;

}

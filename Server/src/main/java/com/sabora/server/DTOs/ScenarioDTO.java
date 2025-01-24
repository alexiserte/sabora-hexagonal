package com.sabora.server.DTOs;

import com.sabora.server.Models.Sound;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScenarioDTO {
    private int id;
    private String name;
    private String place;
    private String photoPath;
    private Sound sound;
}

package com.sabora.api.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ScenarioDTO {
    private int id;
    private String name;
    private String place;
    private String photoPath;
    private String sound;
}

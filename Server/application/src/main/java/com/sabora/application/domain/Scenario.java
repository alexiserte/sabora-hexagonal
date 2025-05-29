package com.sabora.application.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scenario {

    private int id;
    private String name;
    private String place;
    private String photoPath;
    private Sound sound;

}

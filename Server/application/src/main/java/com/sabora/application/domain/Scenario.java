package com.sabora.application.domain;

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

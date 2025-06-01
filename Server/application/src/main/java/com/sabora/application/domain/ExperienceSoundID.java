package com.sabora.application.domain;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class ExperienceSoundID implements Serializable {
    private Integer experienceID;
    private Integer soundID;
}

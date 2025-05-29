package com.sabora.database.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ExperienceSoundID implements Serializable {
    private Integer experienceID;
    private Integer soundID;
}

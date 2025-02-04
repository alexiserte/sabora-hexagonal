package com.sabora.server.Entities;

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
    private int experienceID;
    private int soundID;
}

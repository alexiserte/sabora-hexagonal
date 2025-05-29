package com.sabora.application.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AmbientMusic extends Sound {
    @Builder
    public AmbientMusic(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

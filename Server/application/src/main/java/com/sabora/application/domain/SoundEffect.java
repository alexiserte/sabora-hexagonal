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
public class SoundEffect extends Sound {

    @Builder
    public SoundEffect(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

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
public class Narration extends Sound {

    @Builder
    public Narration(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

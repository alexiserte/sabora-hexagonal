package com.sabora.server.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "efecto_sonido")
@PrimaryKeyJoinColumn(name = "id_sonido")
public class SoundEffect extends Sound {

    @Builder
    public SoundEffect(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

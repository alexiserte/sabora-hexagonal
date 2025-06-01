package com.sabora.database.entities;

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
@Table(name = "musica_ambiental")
@PrimaryKeyJoinColumn(name = "id_sonido")
public class AmbientMusicMO extends SoundMO {

    @Builder
    public AmbientMusicMO(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

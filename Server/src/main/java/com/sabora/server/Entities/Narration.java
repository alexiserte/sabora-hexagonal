package com.sabora.server.Entities;

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
@Table(name = "narracion")
@PrimaryKeyJoinColumn(name = "id_sonido")
public class Narration extends Sound {

    @Builder
    public Narration(int id, String name, String filepath) {
        super(id, name, filepath);
    }
}

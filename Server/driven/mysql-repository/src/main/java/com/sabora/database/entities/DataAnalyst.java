package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "analista_datos")
@PrimaryKeyJoinColumn(name = "dni")
public class DataAnalyst extends User{
    @Builder
    public DataAnalyst(String dni, String name, String apellidos, String email, String password, String telefono, String username) {
        super(dni, name, apellidos, email, password, telefono, username);
    }
}
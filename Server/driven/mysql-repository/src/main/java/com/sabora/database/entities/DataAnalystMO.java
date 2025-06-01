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
@Table(name = "analista_datos")
@PrimaryKeyJoinColumn(name = "dni")
public class DataAnalystMO extends UserMO {
    @Builder
    public DataAnalystMO(String dni, String name, String apellidos, String email, String password, String telefono, String username) {
        super(dni, name, apellidos, email, password, telefono, username);
    }
}
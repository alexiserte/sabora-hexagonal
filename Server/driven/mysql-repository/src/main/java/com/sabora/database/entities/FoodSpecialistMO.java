package com.sabora.database.entities;

import jakarta.persistence.Column;
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
@Table(name = "especialista_alimentacion")
@PrimaryKeyJoinColumn(name = "dni")
public class FoodSpecialistMO extends UserMO {

    @Column(name = "organizacion", length = 20, nullable = false)
    private String organization;

    @Builder
    public FoodSpecialistMO(String dni, String name, String apellidos, String email, String password, String telefono, String username, String organization) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.organization = organization;
    }
}
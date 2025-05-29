package com.sabora.application.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodSpecialist extends User {
    private String organization;

    @Builder
    public FoodSpecialist(String dni, String name, String apellidos, String email, String password, String telefono, String username, String organization) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.organization = organization;
    }
}
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
public class DataAnalyst extends User {
    @Builder
    public DataAnalyst(String dni, String name, String apellidos, String email, String password, String telefono, String username) {
        super(dni, name, apellidos, email, password, telefono, username);
    }
}
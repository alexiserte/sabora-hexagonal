package com.sabora.application.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Check;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlassesUser extends User {
    private int age;
    private String gender;

    @Builder
    public GlassesUser(String dni, String name, String apellidos, String email, String password, String telefono, String username, int age, String gender) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.age = age;
        this.gender = gender;
    }
}
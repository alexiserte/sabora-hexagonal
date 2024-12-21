package com.sabora.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "especialista_alimentacion")
@PrimaryKeyJoinColumn(name = "dni")
public class FoodSpecialist extends User{

    @Column(name="organizacion",length = 20,nullable=false)
    private String organization;

    @Builder
    public FoodSpecialist(String dni, String name, String apellidos, String email, String password, long telefono, String username, String organization) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.organization = organization;
    }
}
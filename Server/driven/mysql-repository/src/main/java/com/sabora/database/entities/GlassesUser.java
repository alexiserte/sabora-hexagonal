package com.sabora.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Check;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario_gafas")
@PrimaryKeyJoinColumn(name = "dni")
@Check(constraints = "sexo IN ('Hombre', 'Mujer', 'Otro')")
public class GlassesUser extends User{

    @Min(0)
    @Max(122)
    @Column(name="edad", nullable=false)
    private int age;

    @Column(name="sexo", nullable=false)
    private String gender;

    @Builder
    public GlassesUser(String dni, String name, String apellidos, String email, String password, String telefono, String username, int age, String gender) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.age = age;
        this.gender = gender;
    }
}
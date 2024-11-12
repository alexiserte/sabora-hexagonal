package com.sabora.server.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
}
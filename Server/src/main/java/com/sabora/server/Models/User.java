package com.sabora.server.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @Column(name="dni", length=9)
    private String dni;

    @Column(name="nombre", length=20, nullable=false)
    private String name;

    @Column(name="apellidos", length=50, nullable=false)
    private String apellidos;

    @Column(name="email", length=30, nullable=false, unique=true)
    @Email(message="El email debe ser válido")
    private String email;

    @Column(name = "contrasenya", columnDefinition = "LONGTEXT", nullable = false)
    @Lob
    private String password;


    @Column(name="telefono",nullable=false,unique = true)
    private long telefono;
    /*  Funcionará con teléfonos españoles, pero si se trata de algún número internacional que empiece por cero puede causar problemas*/

    @Column(name="username", length=20, nullable=false, unique = true)
    private String username;

}

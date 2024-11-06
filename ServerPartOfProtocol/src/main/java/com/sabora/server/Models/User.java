package com.sabora.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name="dni", length=9)
    private String dni;

    @Column(name="nombre", length=20, nullable=false)
    private String name;

    @Column(name="apellidos", length=50, nullable=false)
    private String apellidos;

    @Column(name="email", length=30, nullable=false, unique=true)
    private String email;

    @Column(name="contrasenya", length=20, nullable=false)
    private String password;

    @Column(name="telefono",nullable=false,unique = true)
    private long telefono;

    @Column(name="username", length=20, nullable=false, unique = true)
    private String username;

}

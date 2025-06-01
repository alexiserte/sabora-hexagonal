package com.sabora.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UserMO {

    @Id
    @Column(name = "dni", length = 750)
    private String dni;

    @Column(name = "nombre", length = 20, nullable = false)
    private String name;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "email", length = 750, nullable = false, unique = true)
    @Email(message = "El email debe ser válido")
    private String email;

    @Column(name = "contrasenya", columnDefinition = "LONGTEXT", nullable = false)
    @Lob
    private String password;


    @Column(name = "telefono", length = 750, nullable = false, unique = true)
    private String telefono;
    /*  Funcionará con teléfonos españoles, pero si se trata de algún número internacional que empiece por cero puede causar problemas*/

    @Column(name = "username", length = 20, nullable = false, unique = true)
    private String username;

}

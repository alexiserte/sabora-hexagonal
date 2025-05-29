package com.sabora.database.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "dni")
public class Cliente extends User{

    @Column(name="empresa", length=20, nullable=false)
    private String business;

    @Column(name="cuenta_bancaria", length=512, nullable=false)
    private String bankAccount;

    @Builder
    public Cliente(String dni, String name, String apellidos, String email, String password, String telefono, String username, String business, String bankAccount) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.business = business;
        this.bankAccount = bankAccount;
    }
}
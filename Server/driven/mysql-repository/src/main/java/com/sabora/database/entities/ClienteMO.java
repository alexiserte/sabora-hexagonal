package com.sabora.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "dni")
public class ClienteMO extends UserMO {

    @Column(name = "empresa", length = 20, nullable = false)
    private String business;

    @Column(name = "cuenta_bancaria", length = 512, nullable = false)
    private String bankAccount;

    @Builder
    public ClienteMO(String dni, String name, String apellidos, String email, String password, String telefono, String username, String business, String bankAccount) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.business = business;
        this.bankAccount = bankAccount;
    }
}
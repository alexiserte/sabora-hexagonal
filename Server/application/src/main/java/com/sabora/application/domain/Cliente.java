package com.sabora.application.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends User {

    private String business;
    private String bankAccount;

    @Builder
    public Cliente(String dni, String name, String apellidos, String email, String password, String telefono, String username, String business, String bankAccount) {
        super(dni, name, apellidos, email, password, telefono, username);
        this.business = business;
        this.bankAccount = bankAccount;
    }
}
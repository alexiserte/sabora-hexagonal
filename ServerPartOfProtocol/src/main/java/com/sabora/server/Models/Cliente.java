package com.sabora.server.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "dni")
public class Cliente extends User{

    @Column(name="empresa", length=20, nullable=false)
    private String business;

    @Column(name="cuenta_bancaria", length=24, nullable=false)
    private String bankAccount;
}
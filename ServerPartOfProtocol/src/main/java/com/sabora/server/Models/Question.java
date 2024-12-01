package com.sabora.server.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pregunta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="valor", length=100, nullable=false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "id_formulario", referencedColumnName = "id", nullable = false)
    private Form form;
}

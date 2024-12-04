package com.sabora.server.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "respuesta")
@Inheritance(strategy = InheritanceType.JOINED)
public class Answer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="valor", length=2500, nullable=false)
    private String value;


    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id", nullable = false)
    private Question question;

    //Falta el campo id_experiencia que es la experiencia a la que pertenece la respuesta, cuando se cree la entidad experiencia se añadirá
}

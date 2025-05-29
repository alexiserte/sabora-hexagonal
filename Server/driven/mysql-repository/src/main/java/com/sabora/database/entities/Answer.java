package com.sabora.database.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "respuesta")
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

    @ManyToOne
    @JoinColumn(name = "id_experiencia", referencedColumnName = "id", nullable = false)
    private Experience experience;

    @Column(name="fecha_respuesta", nullable=false)
    private java.time.LocalDateTime answerTimeStamp;

    @Column(name="id_usuario_gafas", nullable=false, length = 750)
    private String author;
}

package com.sabora.FormStatisticsService.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="formulario_informacion")
public class FormDescription {

    @Id
    @Column(name="id_formulario")
    private long id;

    @Column(name="analisis_formulario", columnDefinition = "LONGTEXT")
    private String form_analysis;


    @Column(name="analisis_respuestas", columnDefinition = "LONGTEXT")
    private String response_analysis;

}
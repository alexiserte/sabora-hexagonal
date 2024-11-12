package com.sabora.server.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "especialista_alimentacion")
@PrimaryKeyJoinColumn(name = "dni")
public class FoodSpecialist extends User{

    @Column(name="organizacion",length = 20,nullable=false)
    private String organization;
}
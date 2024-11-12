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
@Table(name = "analista_datos")
@PrimaryKeyJoinColumn(name = "dni")
public class DataAnalyst extends User{ }
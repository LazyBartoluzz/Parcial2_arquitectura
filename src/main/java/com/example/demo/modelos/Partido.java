package com.example.demo.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String estadio;
    private Integer golesLocal;
    private Integer golesVisita;

    //1 id equipo (local)

    //1 id equipo (visitante)

}

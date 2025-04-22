package com.example.demo.modelos;

import java.time.LocalDate;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Equipo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;
    private LocalDate fundacion;

    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Jugador> jugadores;

    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Entrenador> entrenadores;

    //-------

    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Partido> partidos;

    //--------




}

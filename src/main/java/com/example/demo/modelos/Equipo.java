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

    //1 id equipo (local)
    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Partido> partidosLocales;

    //1 id equipo (visitante)
    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Partido> partidosVisitante;

    @OneToMany
    @JoinColumn(name = "id_equipo")
    private List<Partido> partidos;

    //--------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    public List<Partido> getPartidosLocales() {
        return partidosLocales;
    }

    public void setPartidosLocales(List<Partido> partidosLocales) {
        this.partidosLocales = partidosLocales;
    }

    public List<Partido> getPartidosVisitante() {
        return partidosVisitante;
    }

    public void setPartidosVisitante(List<Partido> partidosVisitante) {
        this.partidosVisitante = partidosVisitante;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}

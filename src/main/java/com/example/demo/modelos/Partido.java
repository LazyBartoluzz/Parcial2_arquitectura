package com.example.demo.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private String estadio;
    private Integer golesLocal;
    private Integer golesVisita;

    @OneToMany
    @JoinColumn(name = "id_partido")
    private List<EstadisticaJugador> estadisticasJugadores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(Integer golesVisita) {
        this.golesVisita = golesVisita;
    }

    public List<EstadisticaJugador> getEstadisticasJugadores() {
        return estadisticasJugadores;
    }

    public void setEstadisticasJugadores(List<EstadisticaJugador> estadisticasJugadores) {
        this.estadisticasJugadores = estadisticasJugadores;
    }
}

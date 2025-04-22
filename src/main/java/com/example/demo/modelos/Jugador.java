package com.example.demo.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Jugador
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String posicion;
    private Integer dorsal;
    private LocalDate fechaNacimiento;
    private String nacionalidad;

    @OneToMany
    @JoinColumn(name = "id_jugador")
    private List<EstadisticaJugador> estadisticas;

}

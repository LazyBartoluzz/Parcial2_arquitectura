package com.example.demo.servicios;

import com.example.demo.modelos.Jugador;
import com.example.demo.repositorios.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> findById(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteById(Long id) {
        jugadorRepository.deleteById(id);
    }

    // Consulta 1: jugadores por equipo
    public List<Jugador> findByEquipo(Long equipoId) {
        return jugadorRepository.findJugadoresByEquipo(equipoId);
    }

    // Consulta 2: jugadores con más de X goles
    public List<Jugador> findJugadoresConMasDeGoles(Integer goles) {
        return jugadorRepository.findJugadoresConMasDeGoles(goles);
    }
}

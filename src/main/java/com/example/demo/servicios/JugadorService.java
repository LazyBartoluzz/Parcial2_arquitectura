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

    // Obtener todos los jugadores
    public List<Jugador> obtenerTodos() {
        return jugadorRepository.findAll();
    }

    // Obtener jugador por ID
    public Optional<Jugador> obtenerPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    // Guardar jugador
    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Eliminar jugador
    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }

    // Obtener jugadores de un equipo específico
    public List<Jugador> obtenerJugadoresPorEquipo(Long idEquipo) {
        return jugadorRepository.findByEquipoId(idEquipo);
    }

    // Obtener jugadores que han marcado más de X goles
    public List<Jugador> obtenerJugadoresConGolesMayoresA(Integer goles) {
        return jugadorRepository.findJugadoresConGolesMayoresA(goles);
    }
}

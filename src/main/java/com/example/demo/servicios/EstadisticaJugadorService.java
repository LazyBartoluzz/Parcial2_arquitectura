package com.example.demo.servicios;

import com.example.demo.modelos.EstadisticaJugador;
import com.example.demo.repositorios.EstadisticaJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorService {

    @Autowired
    private EstadisticaJugadorRepository estadisticaJugadorRepository;

    // Obtener todas las estadísticas de jugadores
    public List<EstadisticaJugador> obtenerTodas() {
        return estadisticaJugadorRepository.findAll();
    }

    // Obtener estadística de jugador por ID
    public Optional<EstadisticaJugador> obtenerPorId(Long id) {
        return estadisticaJugadorRepository.findById(id);
    }

    // Guardar estadística de jugador
    public EstadisticaJugador guardar(EstadisticaJugador estadisticaJugador) {
        return estadisticaJugadorRepository.save(estadisticaJugador);
    }

    // Eliminar estadística de jugador
    public void eliminar(Long id) {
        estadisticaJugadorRepository.deleteById(id);
    }
}

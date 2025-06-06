package com.example.demo.servicios;

import com.example.demo.modelos.Partido;
import com.example.demo.repositorios.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> findById(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deleteById(Long id) {
        partidoRepository.deleteById(id);
    }

    // Consulta 3: total de goles de un equipo
    public Integer totalGolesPorEquipo(Long equipoId) {
        return partidoRepository.totalGolesPorEquipo(equipoId);
    }

    // Consulta 4: resultados de partidos con nombres de equipos
    public List<Map<String, Object>> obtenerResultadosConNombresEquipos() {
        return partidoRepository.obtenerResultadosConNombresEquipos();
    }
}

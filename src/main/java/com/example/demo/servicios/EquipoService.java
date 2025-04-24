package com.example.demo.servicios;

import com.example.demo.modelos.Equipo;
import com.example.demo.repositorios.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    // Obtener todos los equipos
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    // Obtener equipo por ID
    public Optional<Equipo> obtenerPorId(Long id) {
        return equipoRepository.findById(id);
    }

    // Guardar equipo
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    // Eliminar equipo
    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }

    // Obtener total de goles marcados por un equipo en todos sus partidos
    public Integer obtenerTotalGolesPorEquipo(Long idEquipo) {
        return equipoRepository.obtenerTotalGolesPorEquipo(idEquipo);
    }
}

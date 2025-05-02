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
    private EstadisticaJugadorRepository estadisticaRepository;

    public List<EstadisticaJugador> findAll() {
        return estadisticaRepository.findAll();
    }

    public Optional<EstadisticaJugador> findById(Long id) {
        return estadisticaRepository.findById(id);
    }

    public EstadisticaJugador save(EstadisticaJugador estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    public void deleteById(Long id) {
        estadisticaRepository.deleteById(id);
    }
}

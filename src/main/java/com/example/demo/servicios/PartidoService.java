package com.example.demo.servicios;

import com.example.demo.repositorios.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    // Obtener resultados de todos los partidos con nombres de los equipos
    public List<Object[]> obtenerResultadosPartidos() {
        return partidoRepository.obtenerResultadosPartidos();
    }
}
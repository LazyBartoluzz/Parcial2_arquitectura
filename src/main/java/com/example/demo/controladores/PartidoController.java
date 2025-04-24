package com.example.demo.controladores;

import com.example.demo.servicios.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    // Obtener los resultados de todos los partidos con los nombres de los equipos
    @GetMapping("/resultados")
    public List<Object[]> obtenerResultadosPartidos() {
        return partidoService.obtenerResultadosPartidos();
    }
}
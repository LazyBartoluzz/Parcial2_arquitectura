package com.example.demo.controladores;

import com.example.demo.modelos.Equipo;
import com.example.demo.servicios.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Obtener todos los equipos
    @GetMapping
    public List<Equipo> obtenerTodos() {
        return equipoService.obtenerTodos();
    }

    // Obtener equipo por ID
    @GetMapping("/{id}")
    public Optional<Equipo> obtenerPorId(@PathVariable Long id) {
        return equipoService.obtenerPorId(id);
    }

    // Crear un nuevo equipo
    @PostMapping
    public Equipo guardar(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    // Eliminar equipo por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
    }

    // Obtener total de goles marcados por un equipo en todos sus partidos
    @GetMapping("/{idEquipo}/total-goles")
    public Integer obtenerTotalGolesPorEquipo(@PathVariable Long idEquipo) {
        return equipoService.obtenerTotalGolesPorEquipo(idEquipo);
    }
}

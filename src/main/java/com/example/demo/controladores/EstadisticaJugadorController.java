package com.example.demo.controladores;

import com.example.demo.modelos.EstadisticaJugador;
import com.example.demo.servicios.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas-jugadores")
public class EstadisticaJugadorController {

    @Autowired
    private EstadisticaJugadorService estadisticaJugadorService;

    // Obtener todas las estadísticas de jugadores
    @GetMapping
    public List<EstadisticaJugador> obtenerTodas() {
        return estadisticaJugadorService.obtenerTodas();
    }

    // Obtener estadística de jugador por ID
    @GetMapping("/{id}")
    public Optional<EstadisticaJugador> obtenerPorId(@PathVariable Long id) {
        return estadisticaJugadorService.obtenerPorId(id);
    }

    // Crear una nueva estadística de jugador
    @PostMapping
    public EstadisticaJugador guardar(@RequestBody EstadisticaJugador estadisticaJugador) {
        return estadisticaJugadorService.guardar(estadisticaJugador);
    }

    // Eliminar estadística de jugador por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estadisticaJugadorService.eliminar(id);
    }
}
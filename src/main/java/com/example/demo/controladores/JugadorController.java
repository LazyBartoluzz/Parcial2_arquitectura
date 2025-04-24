package com.example.demo.controladores;

import com.example.demo.modelos.Jugador;
import com.example.demo.servicios.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Obtener todos los jugadores
    @GetMapping
    public List<Jugador> obtenerTodos() {
        return jugadorService.obtenerTodos();
    }

    // Obtener jugador por ID
    @GetMapping("/{id}")
    public Optional<Jugador> obtenerPorId(@PathVariable Long id) {
        return jugadorService.obtenerPorId(id);
    }

    // Obtener jugadores de un equipo específico
    @GetMapping("/equipo/{idEquipo}")
    public List<Jugador> obtenerJugadoresPorEquipo(@PathVariable Long idEquipo) {
        return jugadorService.obtenerJugadoresPorEquipo(idEquipo);
    }

    // Obtener jugadores con más de X goles
    @GetMapping("/goles-mayores-a/{goles}")
    public List<Jugador> obtenerJugadoresConGolesMayoresA(@PathVariable Integer goles) {
        return jugadorService.obtenerJugadoresConGolesMayoresA(goles);
    }

    // Crear un nuevo jugador
    @PostMapping
    public Jugador guardar(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    // Eliminar jugador por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        jugadorService.eliminar(id);
    }
}
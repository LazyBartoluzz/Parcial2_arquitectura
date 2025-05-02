package com.example.demo.controladores;

import com.example.demo.modelos.Jugador;
import com.example.demo.servicios.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getById(@PathVariable Long id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> update(@PathVariable Long id, @RequestBody Jugador jugador) {
        if (!jugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jugador.setId(id);
        return ResponseEntity.ok(jugadorService.save(jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 1: jugadores por equipo
    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> getByEquipo(@PathVariable Long equipoId) {
        return jugadorService.findByEquipo(equipoId);
    }

    // Consulta 2: jugadores con más de X goles
    @GetMapping("/goles-mayores-a/{goles}")
    public List<Jugador> getJugadoresConMasGoles(@PathVariable Integer goles) {
        return jugadorService.findJugadoresConMasDeGoles(goles);
    }
}

package com.example.demo.controladores;

import com.example.demo.modelos.EstadisticaJugador;
import com.example.demo.servicios.EstadisticaJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaJugadorController {

    @Autowired
    private EstadisticaJugadorService estadisticaService;

    @GetMapping
    public List<EstadisticaJugador> getAll() {
        return estadisticaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> getById(@PathVariable Long id) {
        return estadisticaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EstadisticaJugador create(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaService.save(estadistica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadisticaJugador> update(@PathVariable Long id, @RequestBody EstadisticaJugador estadistica) {
        if (!estadisticaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estadistica.setId(id);
        return ResponseEntity.ok(estadisticaService.save(estadistica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estadisticaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

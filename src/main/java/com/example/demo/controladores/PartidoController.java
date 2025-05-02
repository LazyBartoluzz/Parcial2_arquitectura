package com.example.demo.controladores;

import org.springframework.web.bind.annotation.RestController;
import com.example.demo.servicios.PartidoService;
import com.example.demo.modelos.Partido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> getAll() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getById(@PathVariable Long id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido create(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> update(@PathVariable Long id, @RequestBody Partido partido) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partido.setId(id);
        return ResponseEntity.ok(partidoService.save(partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Consulta 3: total goles de un equipo
    @GetMapping("/total-goles/{equipoId}")
    public ResponseEntity<Integer> getTotalGolesEquipo(@PathVariable Long equipoId) {
        return ResponseEntity.ok(partidoService.totalGolesPorEquipo(equipoId));
    }

    // Consulta 4: resultados con nombres de equipos
    @GetMapping("/resultados")
    public List<Map<String, Object>> getResultadosConNombresEquipos() {
        return partidoService.obtenerResultadosConNombresEquipos();
    }
}

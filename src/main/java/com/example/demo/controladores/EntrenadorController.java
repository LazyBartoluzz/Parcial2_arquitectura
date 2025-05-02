package com.example.demo.controladores;

import com.example.demo.modelos.Entrenador;
import com.example.demo.servicios.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getById(@PathVariable Long id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> update(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        if (!entrenadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        entrenador.setId(id);
        return ResponseEntity.ok(entrenadorService.save(entrenador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entrenadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

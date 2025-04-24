package com.example.demo.controladores;

import com.example.demo.modelos.Entrenador;
import com.example.demo.servicios.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    // Obtener todos los entrenadores
    @GetMapping
    public List<Entrenador> obtenerTodos() {
        return entrenadorService.obtenerTodos();
    }

    // Obtener entrenador por ID
    @GetMapping("/{id}")
    public Optional<Entrenador> obtenerPorId(@PathVariable Long id) {
        return entrenadorService.obtenerPorId(id);
    }

    // Crear un nuevo entrenador
    @PostMapping
    public Entrenador guardar(@RequestBody Entrenador entrenador) {
        return entrenadorService.guardar(entrenador);
    }

    // Eliminar entrenador por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        entrenadorService.eliminar(id);
    }
}

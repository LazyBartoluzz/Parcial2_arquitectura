package com.example.demo.servicios;

import com.example.demo.modelos.Entrenador;
import com.example.demo.repositorios.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    // Obtener todos los entrenadores
    public List<Entrenador> obtenerTodos() {
        return entrenadorRepository.findAll();
    }

    // Obtener entrenador por ID
    public Optional<Entrenador> obtenerPorId(Long id) {
        return entrenadorRepository.findById(id);
    }

    // Guardar entrenador
    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    // Eliminar entrenador
    public void eliminar(Long id) {
        entrenadorRepository.deleteById(id);
    }
}
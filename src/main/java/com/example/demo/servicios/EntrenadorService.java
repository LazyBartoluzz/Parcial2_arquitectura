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

    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> findById(Long id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteById(Long id) {
        entrenadorRepository.deleteById(id);
    }
}

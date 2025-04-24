package com.example.demo.repositorios;

import com.example.demo.modelos.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    @Query(value = "SELECT p.id, e1.nombre AS equipo_local, e2.nombre AS equipo_visitante, p.resultado " +
            "FROM partido p " +
            "JOIN equipo e1 ON p.id_equipo_local = e1.id " +
            "JOIN equipo e2 ON p.id_equipo_visitante = e2.id", nativeQuery = true)
    List<Object[]> obtenerResultadosPartidos();
}

package com.example.demo.repositorios;

import com.example.demo.modelos.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    @Query(value = "SELECT SUM(ej.goles) FROM estadistica_jugador ej " +
            "JOIN jugador j ON ej.id_jugador = j.id " +
            "WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    Integer obtenerTotalGolesPorEquipo(@Param("idEquipo") Long idEquipo);
}

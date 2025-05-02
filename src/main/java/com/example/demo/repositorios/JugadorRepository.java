package com.example.demo.repositorios;

import com.example.demo.modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    // 1. Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :equipoId", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(@Param("equipoId") Long equipoId);

    // 2. Obtener los jugadores que han marcado más de X número de goles
    @Query(value = """
        SELECT j.*
        FROM jugador j
        JOIN estadistica_jugador ej ON j.id = ej.id_jugador
        GROUP BY j.id
        HAVING SUM(ej.goles) > :goles
    """, nativeQuery = true)
    List<Jugador> findJugadoresConMasDeGoles(@Param("goles") Integer goles);
}

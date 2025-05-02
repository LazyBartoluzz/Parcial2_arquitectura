package com.example.demo.repositorios;

import com.example.demo.modelos.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    // 3. Obtener el número total de goles marcados por un equipo en todos sus partidos
    @Query(value = """
        SELECT 
          COALESCE(SUM(
            CASE 
              WHEN p.id_equipo_local = :equipoId THEN p.goles_local
              WHEN p.id_equipo_visitante = :equipoId THEN p.goles_visita
              ELSE 0
            END
          ), 0) AS total_goles
        FROM partido p
        WHERE p.id_equipo_local = :equipoId OR p.id_equipo_visitante = :equipoId
    """, nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("equipoId") Long equipoId);

    // 4. Obtener los resultados de todos los partidos indicando los nombres de los equipos
    @Query(value = """
        SELECT 
          p.id,
          el.nombre AS equipo_local,
          ev.nombre AS equipo_visitante,
          p.goles_local,
          p.goles_visita,
          p.fecha
        FROM partido p
        JOIN equipo el ON p.id_equipo_local = el.id
        JOIN equipo ev ON p.id_equipo_visitante = ev.id
    """, nativeQuery = true)
    List<Map<String, Object>> obtenerResultadosConNombresEquipos();
}

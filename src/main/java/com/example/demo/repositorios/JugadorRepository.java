package com.example.demo.repositorios;

import com.example.demo.modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findByEquipoId(@Param("idEquipo") Long idEquipo);


    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadistica_jugador ej ON j.id = ej.id_jugador " +
            "GROUP BY j.id HAVING SUM(ej.goles) > :goles", nativeQuery = true)
    List<Jugador> findJugadoresConGolesMayoresA(@Param("goles") Integer goles);

    /**
     *
     * Las queries native methods como tal sirven para hacer consultas, pero pasa que usan el lenguaje SQL nativo del
     * gestor de base de datos que se esta usando, en este caso se usa  Postgres SQl y las consultas que se usan con complejas
     * en su lenguaje
     */
}
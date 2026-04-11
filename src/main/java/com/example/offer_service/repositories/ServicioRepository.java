package com.example.offer_service.repositories;

import com.example.offer_service.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT DISTINCT s.* FROM servicio s "+
            "WHERE (" +
            "LOWER(s.titulo) LIKE LOWER(CONCAT('%', ?1, '%'))" +
            "OR LOWER(s.descripcion) LIKE LOWER(CONCAT('%', ?1, '%'))" +
            "OR LOWER(s.categoria) LIKE LOWER(CONCAT('%', ?1, '%')))" +
            "AND LOWER(s.estado) = 'activo'"
            , nativeQuery = true)
    List<Servicio> buscarServicios(String query);
}

package com.example.offer_service.repositories;

import com.example.offer_service.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Query(value = "SELECT DISTINCT s.* FROM servicio s "+
            "WHERE (" +
            "LOWER(s.titulo) LIKE LOWER(CONCAT('%', ?1, '%'))" +
            "OR LOWER(s.descripcion) LIKE LOWER(CONCAT('%', ?1, '%'))" +
            "OR LOWER(s.categoria) LIKE LOWER(CONCAT('%', ?1, '%')))" +
            "AND LOWER(s.estado) = 'activo'" +
            "AND (?2 IS NULL OR UPPER(?2) = 'TODOS' OR LOWER(s.categoria) = LOWER(?2) )" +
            "AND (?3 IS NULL OR ?3 = 0.0 OR (s.precio <= ?3) )"
            , nativeQuery = true)
    List<Servicio> buscarServicios(String query, String categoria, Double precio);

    List<Servicio> findByProveedorId(Long proveedorId);
    List<Servicio> findByCategoria(String categoria);

    @Query("SELECT s FROM Servicio s WHERE s.proveedorId IN :proveedorIds")
    List<Servicio> findServicesByProveedorId(@Param("proveedorIds") List<Long> proveedorIds);
}

package com.example.offer_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String categoria;

//    @ElementCollection
//    private List<String> tags;

    private Double precio;
    private Integer duracion; // en minutos
    private String modalidad; // PRESENCIAL / ONLINE
    private String ubicacion;
    private String estado;


    // Relación con usuario en otro microservicio
    private Long proovedorId;

    private LocalDateTime fechaCreacion;

    public Servicio() {
    }

    public Servicio(String titulo, String descripcion, String categoria, Double precio, Integer duracion, String modalidad, String ubicacion, Long proovedorId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.duracion = duracion;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        estado = "activo";
        this.proovedorId = proovedorId;
        fechaCreacion = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getProovedorId() {
        return proovedorId;
    }

    public void setProovedorId(Long proovedorId) {
        this.proovedorId = proovedorId;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

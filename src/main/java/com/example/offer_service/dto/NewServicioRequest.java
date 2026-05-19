package com.example.offer_service.dto;

import com.example.offer_service.dto.enums.Categoria;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class NewServicioRequest {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no debe superar 100 caracteres")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 500, message = "La descripción no debe superar 500 caracteres")
    private String descripcion;

    @NotNull(message = "La categoría es obligatoria")
    private Categoria categoria;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "La duración es obligatoria")
    @Min(value=30, message = "La duración mínima es 30 minutos")
    private Integer duracion;

    @NotBlank(message = "La modalidad es obligatoria")
    @Pattern(regexp = "Presencial|Online", message = "El campo modalidad debe ser Presencial o Online")
    private String modalidad; // PRESENCIAL / ONLINE

    @NotBlank(message = "La ubicacion es obligatoria")
    private String ubicacion;

    @NotNull(message = "El id del proveedor es obligatorio")
    @Positive(message = "El id del proveedor debe ser positivo")
    private Long proveedorId;

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

    public String getCategoriaString() {
        return categoria.name();
    }

    public Categoria getCategoria(){return categoria;}

    public void setCategoria(Categoria categoria) {
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

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }
}


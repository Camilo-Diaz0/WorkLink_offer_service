package com.example.offer_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BusquedaRequest {

    @NotBlank(message = "Debe ingresar al menos una palabra para la busqueda")
    String query;
    @NotBlank(message = "Debe Ingresar una categoria")
    @Pattern(regexp = "Educacion|Arte|Eventos|TODOS", message = "Ingrese una categoria valida")
    String categoria;
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio debe ser mayor o igual a 0")
    Double precio;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
}

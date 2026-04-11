package com.example.offer_service.dto;

import jakarta.validation.constraints.NotBlank;

public class BusquedaRequest {

    @NotBlank(message = "Debe ingresar al menos una palabra para la busqueda")
    String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

package com.example.offer_service.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.offer_service.dto.ProveedorResponse;

@FeignClient(name = "proveedores-cercanos", url = "http://localhost:8081")
public interface ProveedoresCercanos {
    @GetMapping("/api/perfil-servidor/cercanos")
    List<ProveedorResponse> obtenerCercanos(@RequestParam("clienteId") Long clienteId, @RequestParam("radioKm") Double radioKm);
}

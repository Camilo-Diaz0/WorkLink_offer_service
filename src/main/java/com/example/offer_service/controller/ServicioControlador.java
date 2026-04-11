package com.example.offer_service.controller;

import com.example.offer_service.dto.BusquedaRequest;
import com.example.offer_service.dto.NewServicioRequest;
import com.example.offer_service.entities.Servicio;
import com.example.offer_service.services.ServicioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioControlador {

    private ServicioService service;

    public ServicioControlador(ServicioService service){
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearServicio(@Valid @RequestBody NewServicioRequest servicioReq){
        Servicio creado = service.crearServicio(servicioReq);
        if(creado == null) return ResponseEntity.badRequest().body("NO se guardo");
        return ResponseEntity.ok(creado);

    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscarServicios(@Valid @RequestBody BusquedaRequest request){
        List<Servicio> servicios = service.buscarServicios(request.getQuery());

        if(servicios == null || servicios.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(servicios);

    }

}

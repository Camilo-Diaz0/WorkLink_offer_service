package com.example.offer_service.controller;

import com.example.offer_service.entities.Servicio;
import com.example.offer_service.services.ServicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
public class ServicioControlador {

    private ServicioService service;

    public ServicioControlador(ServicioService service){
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearServicio(@RequestBody Servicio servicio){
        Servicio creado = service.crearServicio(servicio);
        if(creado == null) return ResponseEntity.badRequest().body("NO se guardo");
        return ResponseEntity.ok(creado);

    }
}

package com.example.offer_service.services;

import com.example.offer_service.entities.Servicio;
import com.example.offer_service.repositories.ServicioRepository;
import org.springframework.stereotype.Component;

@Component
public class ServicioService {

    ServicioRepository repository;

    public ServicioService(ServicioRepository repository){
        this.repository = repository;
    }

    public Servicio crearServicio(Servicio servicio){
        Servicio save = repository.save(servicio);
        if(save.getId() != null) return save;
        return null;
    }
}

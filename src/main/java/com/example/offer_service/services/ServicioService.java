package com.example.offer_service.services;

import com.example.offer_service.dto.NewServicioRequest;
import com.example.offer_service.entities.Servicio;
import com.example.offer_service.repositories.ServicioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioService {

    ServicioRepository repository;

    public ServicioService(ServicioRepository repository){
        this.repository = repository;
    }

    public Servicio crearServicio(NewServicioRequest req){
        Servicio servicio = new Servicio(
                req.getTitulo(),
                req.getDescripcion(),
                req.getCategoriaString(),
                req.getPrecio(),
                req.getDuracion(),
                req.getModalidad(),
                req.getUbicacion(),
                req.getProovedorId()
        );
        Servicio save = repository.save(servicio);
        if(save.getId() != null) return save;
        return null;
    }

    public List<Servicio> buscarServicios(String query){
        return repository.buscarServicios(query);
    }
}

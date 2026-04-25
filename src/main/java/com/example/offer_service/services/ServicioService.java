package com.example.offer_service.services;

import com.example.offer_service.dto.NewServicioRequest;
import com.example.offer_service.dto.UpdateServiceRequest;
import com.example.offer_service.entities.Servicio;
import com.example.offer_service.repositories.ServicioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
                req.getProveedorId()
        );
        Servicio save = repository.save(servicio);
        if(save.getId() != null) return save;
        return null;
    }

    public List<Servicio> buscarServicios(String query){
        return repository.buscarServicios(query);
    }

    public  List<Servicio> obtenerTodos(){
        return repository.findAll();
    }

    public Optional<Servicio> obtenerPorId(Long id){
        return repository.findById(id);
    }

    public Servicio actualizarServicio(Long id, UpdateServiceRequest dto){
        Optional<Servicio> opt = repository.findById(id);
        if(opt.isEmpty()) return null;
        Servicio servicio = opt.get();
        servicio.setTitulo(dto.getTitulo());
        servicio.setDescripcion(dto.getDescripcion());
        servicio.setCategoria(dto.getCategoria().name());
        servicio.setPrecio(dto.getPrecio());
        servicio.setDuracion(dto.getDuracion());
        servicio.setModalidad(dto.getModalidad());
        servicio.setUbicacion(dto.getUbicacion());

        return repository.save(servicio);
    }
    public List<Servicio> listarPorProveedor(Long idProveedor){
        return repository.findByProveedorId(idProveedor);
    }
    public void eliminar(Long id){
        repository.deleteById(id);
    }
    public boolean existe(Long id){
        return repository.existsById(id);
    }
}

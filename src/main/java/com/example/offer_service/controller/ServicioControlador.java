package com.example.offer_service.controller;

import com.example.offer_service.dto.BusquedaRequest;
import com.example.offer_service.dto.NewServicioRequest;
import com.example.offer_service.dto.UpdateServiceRequest;
import com.example.offer_service.entities.Servicio;
import com.example.offer_service.services.ServicioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/busqueda")
    public ResponseEntity<?> buscarServicios(@Valid @RequestBody BusquedaRequest request){
        List<Servicio> servicios = service.buscarServicios(request.getQuery());

        if(servicios == null || servicios.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(servicios);

    }
    @GetMapping("/listar/{proveedorId}")
    public ResponseEntity<List<Servicio>> listarByProveedor(@PathVariable Long proveedorId){
        List<Servicio> servicios = service.listarPorProveedor(proveedorId);

        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Servicio>> listarServicios(){
        List<Servicio> servicios = service.obtenerTodos();
        return ResponseEntity.ok().body(servicios);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        Optional<Servicio> opt = service.obtenerPorId(id);
        if (opt.isPresent()){
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarServicio(@PathVariable Long id, @Valid @RequestBody UpdateServiceRequest servicioReq){
        Servicio actualizado = service.actualizarServicio(id, servicioReq);
        if(actualizado == null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarServicio(@PathVariable Long id){
        if(service.existe(id)){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}

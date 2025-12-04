package com.example.examen.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Equipos;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.service.EquipoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    private final EquiposRepository equiposRepository;

    public EquipoController(EquiposRepository equiposRepository, EquipoService equipoService){
        this.equiposRepository = equiposRepository;
        this.equipoService = equipoService;
    }

    //GET de TODOS
    @GetMapping("/obtener")
    public List<Equipos> getAll() {
        
        return equiposRepository.findAll();
    }

    //POST de un equipo
    @PostMapping("/equipo")
    public ResponseEntity<Equipos> postEquipos(@RequestBody Equipos equipo) {
        equipo.setId(null);
        return ResponseEntity.ok(equipoService.save(equipo));
    }

    //PUT del nombre del equipo
    @PutMapping("/{id}/nombre/{nuevoNombre}")
    public ResponseEntity<Equipos> updateNombre(
            @PathVariable Long id,
            @PathVariable String nuevoNombre) {
 
        Equipos actualizado = equipoService.updateNombre(id, nuevoNombre);
 
        if (actualizado == null) {
            // Puede ser porque no existe o porque el estado es inválido
            return ResponseEntity.badRequest().build();
        }
 
        return ResponseEntity.ok(actualizado);
    }


        //esto es un DELETE de un dato equipo por su id
    @DeleteMapping("/equipoeliminado/{id}")
    public ResponseEntity<Void> borrarDato(@PathVariable Long id) {

        //este if lo que hace es llamar al repository a la funcion existById y si no devuelve un id da el error
    if (!equiposRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    //si a pasado por el if sin dar el error borra el equipo
    equiposRepository.deleteById(id);
    return ResponseEntity.noContent().build(); // 204
    }
    

    


}

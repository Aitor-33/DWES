package com.example.examen.controller;

import java.util.List;
import com.example.examen.repository.ArbitrosRepository;
import com.example.examen.service.ArbitroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.Rol;
import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/arbitros")
public class ArbitrosController {

    private final ArbitroService arbitroService;

    private final ArbitrosRepository arbitrosRepository;


    ArbitrosController(ArbitrosRepository arbitrosRepository, ArbitroService arbitroService) {
        this.arbitrosRepository = arbitrosRepository;
        this.arbitroService = arbitroService;
    }


    //GET de todos los arbitros
    @GetMapping("/obtener")
    public List<Arbitros> getAll() {
        
        return arbitrosRepository.findAll();
    }


    //POST 
    @PostMapping("/crear")
    public ResponseEntity<Arbitros> postEquipos(@RequestBody Arbitros arbitro) {
        arbitro.setId(null);

        return ResponseEntity.ok(arbitroService.save(arbitro));
    }

    //GET de arbitro segun su rol
    @GetMapping("/rol")
    public List<Arbitros> getJugadoresByEquipo(@RequestBody Rol rol) {
        return arbitroService.findByRol(rol);
    
    }

    //DELETE
    @DeleteMapping("/arbitroeliminado/{id}")
    public ResponseEntity<Void> borrarDato(@PathVariable String id) {

        //este if lo que hace es llamar al repository a la funcion existById y si no devuelve un id da el error
    if (!arbitrosRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    //si a pasado por el if sin dar el error borra el arbitro
    arbitrosRepository.deleteById(id);
    return ResponseEntity.noContent().build(); // 204
    }
    
}

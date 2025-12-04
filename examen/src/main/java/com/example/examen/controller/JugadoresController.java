package com.example.examen.controller;

import java.util.List;
import com.example.examen.service.JugadoresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.JugadoresRepository;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

    private final JugadoresService jugadoresService;

    private final JugadoresRepository jugadoresRepository;

        private final EquiposRepository equiposRepository;

        

    public JugadoresController(JugadoresRepository jugadoresRepository, EquiposRepository equiposRepository, JugadoresService jugadoresService) {
            this.jugadoresRepository = jugadoresRepository;
            this.equiposRepository = equiposRepository;
            this.jugadoresService = jugadoresService;
        }


    // GET de todos los jugadores
    @GetMapping("/obtener")
    public List<Jugadores> getAll() {

        return jugadoresRepository.findAll();
    }


    //POST de Jugador
    @PostMapping("/{equipoId}")
    public ResponseEntity<Jugadores> crearJugador(@PathVariable Long equipoId,
            @RequestBody Jugadores jugador) {

        Equipos equipo = equiposRepository.findById(equipoId)
                .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        jugador.setEquipo(equipo);
        return ResponseEntity.ok(jugadoresRepository.save(jugador));
    }


    // GET jugadores por id del equipo
    @GetMapping("/{equipoId}/equipos")
    public List<Jugadores> getJugadoresByEquipo(@PathVariable Long equipoId) {
        return jugadoresService.encontrarPorIdEquipos(equipoId);
    
    }

        // GET jugadores por nombre de equipo
    // @GetMapping("/{nombre}/equipos")
    // public List<Jugadores> getJugadoresByEquipoNombre(@PathVariable String nombre) {
    //     return jugadoresService.encontrarPorNombre_equipo(nombre);
    
    // }


        //PUT para cambiarle el equipo
    @PutMapping("/{id}/jugador/{nuevoEquipo}")
    public ResponseEntity<Jugadores> updateEquipoActual(
            @PathVariable String id,
            @PathVariable Long nuevoEquipo) {
 
        Jugadores actualizado = jugadoresService.updateEquipoJugadores(id, nuevoEquipo);
 
        if (actualizado == null) {
            // Puede ser porque no existe o porque el estado es inválido
            return ResponseEntity.badRequest().build();
        }
 
        return ResponseEntity.ok(actualizado);
    }

}

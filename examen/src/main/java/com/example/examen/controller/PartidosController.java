package com.example.examen.controller;

import com.example.examen.repository.ArbitrosRepository;
import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.PartidosRepository;
import com.example.examen.service.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;
import com.example.examen.entity.Partidos;

@RestController
@RequestMapping("/partidos")
public class PartidosController {

    private final PartidosRepository partidosRepository;

    private final PartidoService partidoService;

    private final ArbitrosRepository arbitrosRepository;

    private final EquiposRepository equiposRepository;

    PartidosController(ArbitrosRepository arbitrosRepository, PartidoService partidoService, EquiposRepository equiposRepository, PartidosRepository partidosRepository) {
        this.arbitrosRepository = arbitrosRepository;
        this.partidoService = partidoService;
        this.equiposRepository = equiposRepository;
        this.partidosRepository = partidosRepository;
    }

    // POST de Jugador
    // @PostMapping("/crear")
    // public ResponseEntity<Partidos> crearPartido(@PathVariable Long equipoId1,  @PathVariable Long equipoId2, @PathVariable String arbitro1Id, @PathVariable String arbitro2Id, @RequestBody Partidos partido) {


    //     partido.setEquipo1_id(equipoId1);
    //     partido.setEquipo2_id(equipoId2);
    //     partido.setArbitro1_id(arbitro1Id);
    //     partido.setArbitro2_id(arbitro2Id);


    //     return ResponseEntity.ok(partidosRepository.save(partido));
    // }

}

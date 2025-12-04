package com.example.examen.service;

import java.util.List;

import com.example.examen.repository.EquiposRepository;
import com.example.examen.repository.JugadoresRepository;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Equipos;
import com.example.examen.entity.Jugadores;

@Service
public class JugadoresService {

    private final JugadoresRepository jugadoresRepository;

    private final EquiposRepository equiposRepository;

    JugadoresService(JugadoresRepository jugadoresRepository, EquiposRepository equiposRepository) {
        this.jugadoresRepository = jugadoresRepository;
        this.equiposRepository = equiposRepository;
    }


    
    public List<Jugadores> encontrarPorIdEquipos(Long equipo_Id){

        return jugadoresRepository.findByEquipo_Id(equipo_Id);
        
    }


    //nom me va no se porque me da todo el rato que no encuentra ningun parametro llamado nombre en equipo
    //     public List<Jugadores> encontrarPorNombre_equipo(String nombre_equipo){

    //     return jugadoresRepository.findByEquipo_equipo_nombre(nombre_equipo);
        
    // }


    //comprueba si el nuevo id del equipo es null si lo es return null

    //haces una variable del nuevoid y la igualas al id nuevo que recoges arriba

    //hago un objeto jugador y le busco por el id de su equipo

    //luego cojo ese mismo objeto nuevo y hago un set del id de su equipo poniendole la variable que declare arriba 

    //y por ultimo return jugador repository.save() y el objeto que e creado arriba

            public Jugadores updateEquipoJugadores(String id, Long nuevoEquipo){

            if (nuevoEquipo == null) {
                return null;
            }
        
            Long quipoNormal = nuevoEquipo;

            Jugadores jugador = jugadoresRepository.findById(id).orElse(null);

            Equipos equipo = equiposRepository.findById(nuevoEquipo).orElse(null);

            jugador.setEquipo(equipo);

            return jugadoresRepository.save(jugador);
        }
//el put pide el id del jugador y de su nuevo equipo

}

package com.example.examen.service;

import org.springframework.stereotype.Service;

import com.example.examen.entity.Equipos;
import com.example.examen.repository.EquiposRepository;

@Service
public class EquipoService {

    private final EquiposRepository equiposRepository;

    public EquipoService(EquiposRepository equiposRepository) {
        this.equiposRepository = equiposRepository;
    }

    //metodo para el POST
        public Equipos save(Equipos equipo){
            return equiposRepository.save(equipo);
        }

        //metodo para el PUT
        public Equipos updateNombre(Long id, String nuevoNombre){

            if (nuevoNombre == null) {
                return null;
            }
        
            String nombreNormal = nuevoNombre;

            Equipos equipo = equiposRepository.findById(id).orElse(null);

            equipo.setNombre_equipo(nombreNormal);

            return equiposRepository.save(equipo);
        }


}

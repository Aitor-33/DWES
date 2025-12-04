package com.example.examen.service;

import com.example.examen.repository.ArbitrosRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.examen.Rol;
import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Equipos;

@Service
public class ArbitroService {

    private final ArbitrosRepository arbitrosRepository;

    ArbitroService(ArbitrosRepository arbitrosRepository) {
        this.arbitrosRepository = arbitrosRepository;
    }


    //metodo para el POST
    public Arbitros save(Arbitros arbitro) {
        return arbitrosRepository.save(arbitro);
    }

        //metodo para el get por Rol
        public List<Arbitros> findByRol(Rol rol){
            return arbitrosRepository.findByRol(rol);
        }

}

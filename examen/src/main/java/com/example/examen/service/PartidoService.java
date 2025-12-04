package com.example.examen.service;
import com.example.examen.repository.PartidosRepository;
import org.springframework.stereotype.Service;

import com.example.examen.entity.Equipos;
import com.example.examen.entity.Partidos;


@Service
public class PartidoService {

    private final PartidosRepository partidosRepository;


    PartidoService(PartidosRepository partidosRepository) {
        this.partidosRepository = partidosRepository;
    }


        public Partidos save(Partidos partido){
            return partidosRepository.save(partido);
        }



}

package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Jugadores;

public interface JugadoresRepository extends JpaRepository<Jugadores, String>{

    List<Jugadores> findByEquipo_Id(Long equipo_Id);

    List<Jugadores> findByEquipo_equipo_nombre(String equipo_nombre);

}

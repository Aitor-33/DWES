package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.entity.Arbitros;
import com.example.examen.entity.Partidos;

public interface PartidosRepository extends JpaRepository<Partidos, String>{

}

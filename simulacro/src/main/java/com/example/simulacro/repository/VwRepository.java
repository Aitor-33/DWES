package com.example.simulacro.repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.simulacro.Tipo;
import com.example.simulacro.entity.Vw;

@Repository
public interface VwRepository extends JpaRepository<Vw, Long> {

    //es muy exquisito con los nombres pon exactamente el de la base de datos
    List<Vw> findByTipo(Tipo tipo);
    List<Vw> findByNombre(String nombre);
    List<Vw> findByFecha(Date fecha);
}

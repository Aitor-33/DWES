package com.example.examen.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partidos {

    @Id
    @GeneratedValue(generator = "uuid") // Le dice a Hibernate que lo genere.
    @GenericGenerator(name = "uuid", strategy = "uuid2") // Le dice a Hibernate que use UUID.
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo1_id", nullable = false)
    private Equipos equipo1_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo2_id", nullable = false)
    private Equipos equipo2_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arbitro1_id", nullable = false)
    private Arbitros arbitro1_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arbitro2_id", nullable = false)
    private Arbitros arbitro2_id;

    public Partidos() {
    }

    public Partidos(String id, Equipos equipo1_id, Equipos equipo2_id, Arbitros arbitro1_id, Arbitros arbitro2_id) {
        this.id = id;
        this.equipo1_id = equipo1_id;
        this.equipo2_id = equipo2_id;
        this.arbitro1_id = arbitro1_id;
        this.arbitro2_id = arbitro2_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Equipos getEquipo1_id() {
        return equipo1_id;
    }

    public void setEquipo1_id(Equipos equipo1_id) {
        this.equipo1_id = equipo1_id;
    }

    public Equipos getEquipo2_id() {
        return equipo2_id;
    }

    public void setEquipo2_id(Equipos equipo2_id) {
        this.equipo2_id = equipo2_id;
    }

    public Arbitros getArbitro1_id() {
        return arbitro1_id;
    }

    public void setArbitro1_id(Arbitros arbitro1_id) {
        this.arbitro1_id = arbitro1_id;
    }

    public Arbitros getArbitro2_id() {
        return arbitro2_id;
    }

    public void setArbitro2_id(Arbitros arbitro2_id) {
        this.arbitro2_id = arbitro2_id;
    }



    


}

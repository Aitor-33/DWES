package com.example.examen.entity;

import org.hibernate.annotations.GenericGenerator;

import com.example.examen.Posicion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugadores {

    @Id
    @GeneratedValue(generator = "uuid") // Le dice a Hibernate que lo genere.
    @GenericGenerator(name = "uuid", strategy = "uuid2") // Le dice a Hibernate que use UUID.

    private String id;

    private int dorsal;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Posicion posicion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipos equipo;

    public Jugadores() {
    }

    public Jugadores(String id, int dorsal, String nombre, String apellido1, String apellido2, Posicion posicion,
            Equipos equipo) {

        this.id = id;
        this.dorsal = dorsal;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.posicion = posicion;
        this.equipo = equipo;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }


    

}

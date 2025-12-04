package com.example.examen.entity;

import org.hibernate.annotations.GenericGenerator;

import com.example.examen.Rol;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "arbitros")
public class Arbitros {

        @Id
    @GeneratedValue(generator = "uuid") // Le dice a Hibernate que lo genere.
    @GenericGenerator(name = "uuid", strategy = "uuid2") // Le dice a Hibernate que use UUID.
    private String id;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private Rol rol;

    
    public Arbitros() {
    }


    public Arbitros(String id, String nombre, String apellido1, String apellido2, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.rol = rol;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
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


    public Rol getRol() {
        return rol;
    }


    public void setRol(Rol rol) {
        this.rol = rol;
    }


}

package com.example.simulacro.entity;

import java.sql.Date;

import com.example.simulacro.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//aqui se le avisa a la clase que es un entity y de que tabla lo es
@Entity
@Table(name = "vw")
public class Vw {

    @Id     //esto de estrategy y lo que va detras es para los id autoincrementales
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //se pone el @column (name = "el nombre de la variable como se llame en sql")
    //y debajo a la variable donde va a ir
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "caballos")
    private Double caballos;

    @Column(name = "peso")
    private Double peso;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Tipo tipo;

    @Column(name = "fecha")
    private Date fecha;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCaballos() {
        return caballos;
    }

    public void setCaballos(Double caballos) {
        this.caballos = caballos;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    

}

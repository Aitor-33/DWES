package com.example.tienda.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
 
    @Column(name = "nombre_cliente", length = 100)
    String nombre_cliente;
 
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fecha_pedido")
    LocalDateTime fecha_pedido;
 
    @Column(name = "importe_total", length = 10)
    double importe_total;
 
    @Column(name = "estado", length = 20)
    String estado;
 
    public PedidoEntity() {
 
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getNombre_cliente() {
        return nombre_cliente;
    }
 
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
 
    public LocalDateTime getFecha_pedido() {
        return fecha_pedido;
    }
 
    public void setFecha_pedido(LocalDateTime fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }
 
    public double getImporte_total() {
        return importe_total;
    }
 
    public void setImporte_total(double importe_total) {
        this.importe_total = importe_total;
    }
 
    public String getEstado() {
        return estado;
    }
 
    public void setEstado(String estado) {
        this.estado = estado;
    }



}

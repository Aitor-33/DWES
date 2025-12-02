package com.example.tienda.model;

import java.time.LocalDateTime;

public class Pedido {
    

    private Long id;
    private String nombreCliente;
    private LocalDateTime fechaPedido;
    private double importeTotal;
    private String estado;

    public Pedido(Long id, String nombreCliente, LocalDateTime fechaPedido, double importeTotal, String estado) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.fechaPedido = fechaPedido;
        this.importeTotal = importeTotal;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



}

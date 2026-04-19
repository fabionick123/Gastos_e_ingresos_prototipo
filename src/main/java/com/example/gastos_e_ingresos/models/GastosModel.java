package com.example.gastos_e_ingresos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class GastosModel {
    @Id
    private String id;
    private double monto;

    private String descripcion;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaGasto;


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaGasto() {
        return fechaGasto;
    }

    public String getId() {
        return id;
    }

    public void setFechaGasto(LocalDate fechaGasto) {
        this.fechaGasto = fechaGasto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}

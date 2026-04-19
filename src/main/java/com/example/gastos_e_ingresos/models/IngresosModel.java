package com.example.gastos_e_ingresos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class IngresosModel {
    @Id
    private String id;
    private double monto;
    private String descripcion;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaIngreso;
    public String getId() {
        return id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}

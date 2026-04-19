package com.example.gastos_e_ingresos.services;

import com.example.gastos_e_ingresos.models.GastosModel;
import org.springframework.stereotype.Service;
import com.example.gastos_e_ingresos.repositories.GastosRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class GastosService {
    private final GastosRepository gastosRepository;

    public GastosService(GastosRepository gastosRepository) {
        this.gastosRepository = gastosRepository;
    }

    public  List<GastosModel> obtenerTodos() {
        return gastosRepository.findAll();
    }

    public Optional<GastosModel> obtenerPorId(String id) {
        return gastosRepository.findById(id);
    }

    public GastosModel crear(GastosModel gasto) {
        return gastosRepository.save(gasto);
    }

    public void eliminar(String id) {
        gastosRepository.deleteById(id);
    }

    public double calcularTotalGastado() {
        return gastosRepository.findAll().stream().mapToDouble(GastosModel::getMonto).sum();
    }

    public List<GastosModel> obtenerPorRangoDeFechas(LocalDate inicio, LocalDate fin) {
        return gastosRepository.findByFechaGastoBetween(inicio, fin);
    }

    public List<GastosModel> obtenerPorFecha(LocalDate fecha){
        return gastosRepository.findByFechaGasto(fecha);
    }

    public List<GastosModel> obtenerPorMontoMayorA(double monto) {
        return gastosRepository.findByMontoGreaterThan(monto);
    }
}

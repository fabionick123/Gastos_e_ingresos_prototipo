package com.example.gastos_e_ingresos.services;

import com.example.gastos_e_ingresos.models.GastosModel;
import com.example.gastos_e_ingresos.models.IngresosModel;
import com.example.gastos_e_ingresos.repositories.IngresosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IngresosService {
    private final IngresosRepository ingresosRepository;

    public IngresosService(IngresosRepository ingresosRepository) {
        this.ingresosRepository = ingresosRepository;
    }
    
    public List<IngresosModel> obtenerTodo(){
        return ingresosRepository.findAll();
    }
    
    public Optional<IngresosModel> obtenerPorId(String id){
        return ingresosRepository.findById(id);
    }
    
    public List<IngresosModel> obtenerPorRangoDeFechas(LocalDate inicio, LocalDate fin){
        return ingresosRepository.findByFechaIngresoBetween(inicio, fin);
    }
    
    public double calcularTotalIngresado(){
        return ingresosRepository.findAll().stream().mapToDouble(IngresosModel::getMonto).sum();
    }
    
    public IngresosModel crear(IngresosModel ingreso){
        return ingresosRepository.save(ingreso);
    }

    public void eliminar(String id){
        ingresosRepository.deleteById(id);
    }

    public List<IngresosModel> obtenerPorFecha(LocalDate fecha){
        return ingresosRepository.findByFechaIngreso(fecha);
    }

    public List<IngresosModel> obtenerPorCantidadMayor(double monto){
        return ingresosRepository.findByMontoGreaterThan(monto);
    }
}

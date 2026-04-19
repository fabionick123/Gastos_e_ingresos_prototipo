package com.example.gastos_e_ingresos.controllers;

import com.example.gastos_e_ingresos.models.GastosModel;
import com.example.gastos_e_ingresos.services.GastosService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/gastos")
public class GastosController {

    private final GastosService gastosService;

    public GastosController(GastosService gastosService) {
        this.gastosService = gastosService;
    }

    @GetMapping("/todo")
    public List<GastosModel> filtrarGastos(){
        return gastosService.obtenerTodos();
    }

    @GetMapping
    public List<GastosModel> obtenerTodos(){
        return gastosService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastosModel> obtenerPorId(@PathVariable String id) {
        return gastosService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/anadir")
    public GastosModel crear(@RequestBody GastosModel gasto) {
        return gastosService.crear(gasto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        gastosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> obtenerTotal() {
        return ResponseEntity.ok(gastosService.calcularTotalGastado());
    }

    @GetMapping("/rango")
    public List<GastosModel> obtenerPorRango(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate inicio,
                                             @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate fin) {
        return gastosService.obtenerPorRangoDeFechas(inicio, fin);

    }
    @GetMapping("/mayor")
    public List<GastosModel> obtenerPorMontoMayorA(@RequestParam double monto) {
        return gastosService.obtenerPorMontoMayorA(monto);
    }
    @GetMapping("fecha")
    public List<GastosModel> obteenerPorFecha(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha){
        return gastosService.obtenerPorFecha(fecha);
    }
}
package com.example.gastos_e_ingresos.controllers;

import com.example.gastos_e_ingresos.models.GastosModel;
import com.example.gastos_e_ingresos.models.IngresosModel;
import com.example.gastos_e_ingresos.services.IngresosService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/ingresos")
public class IngresosController {
    private final IngresosService ingresosService;

    public IngresosController(IngresosService ingresosService) {
        this.ingresosService = ingresosService;
    }
    @GetMapping("/todo")
    public List<IngresosModel> filtrarIngresos(){
        return ingresosService.obtenerTodo();
    }

    @GetMapping
    public List<IngresosModel> obtenerTodo(){
        return ingresosService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngresosModel> obtenerPorId(@PathVariable String id){
        return ingresosService.obtenerPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/anadir")
    public IngresosModel crear(@RequestBody IngresosModel ingreso){
        return ingresosService.crear(ingreso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar (@PathVariable String id){
        ingresosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/total")
    public ResponseEntity<Double> obtenerTotal(){
        return ResponseEntity.ok(ingresosService.calcularTotalIngresado());
    }

    @GetMapping("/rango")
    public List<IngresosModel> obtenerPorRango(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio,
                                               @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")LocalDate fin) {
        return ingresosService.obtenerPorRangoDeFechas(inicio, fin);
    }

    @GetMapping("/mayor")
    public List<IngresosModel> obtnerPorMontoMayorA(@RequestParam double monto){
        return ingresosService.obtenerPorCantidadMayor(monto);
    }

    @GetMapping("/fecha")
    public List<IngresosModel> obtenerPorFecha(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha){
        return ingresosService.obtenerPorFecha(fecha);
    }
}

package com.example.gastos_e_ingresos.repositories;

import com.example.gastos_e_ingresos.models.GastosModel;
import com.example.gastos_e_ingresos.models.IngresosModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngresosRepository extends MongoRepository<IngresosModel, String> {
    Optional<IngresosModel> findById(String id);
    List<IngresosModel> findByFechaIngreso(LocalDate fechaIngreso);

    @Query("{ 'fechaIngreso' : { $gte: ?0, $lte: ?1 } }")
    List<IngresosModel> findByFechaIngresoBetween(LocalDate inicio, LocalDate fin);

    List<IngresosModel> findByMontoGreaterThan(double monto);
}

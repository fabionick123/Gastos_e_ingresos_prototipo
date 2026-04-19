package com.example.gastos_e_ingresos.repositories;

import com.example.gastos_e_ingresos.models.GastosModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface GastosRepository extends MongoRepository<GastosModel, String> {
    Optional<GastosModel> findById(String id);

    List<GastosModel> findByFechaGasto(LocalDate fechaGasto);

    @Query("{ 'fechaGasto' : { $gte: ?0, $lte: ?1 } }")
    List<GastosModel> findByFechaGastoBetween(LocalDate inicio, LocalDate fin);

    List<GastosModel> findByMontoGreaterThan(double monto);
}
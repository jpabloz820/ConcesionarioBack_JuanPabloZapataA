package com.concesionario.ordenes_trabajo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.concesionario.ordenes_trabajo.entity.Vehicle;

public interface VehicleRepository extends JpaRepository <Vehicle, Long>{
    Optional<Vehicle> findByPlate(String plate);
}

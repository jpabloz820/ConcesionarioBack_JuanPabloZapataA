package com.concesionario.ordenes_trabajo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.concesionario.ordenes_trabajo.entity.Vehicle;
import com.concesionario.ordenes_trabajo.repository.VehicleRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle save(Vehicle vehicle) {
        if (vehicleRepository.findByPlate(vehicle.getPlate()).isPresent()) {
            throw new EntityExistsException("El vehículo con placa " + vehicle.getPlate() + " ya existe");
        }
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado"));
    }

    public Vehicle update(Long id, Vehicle vehicleDetails) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado"));

        existingVehicle.setPlate(vehicleDetails.getPlate());
        existingVehicle.setModel(vehicleDetails.getModel());
        existingVehicle.setBrand(vehicleDetails.getBrand());
        existingVehicle.setYear(vehicleDetails.getYear());

        return vehicleRepository.save(existingVehicle);
    }

    public void delete(Long id) {
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado"));
        vehicleRepository.delete(existingVehicle);
    }
}



package com.concesionario.ordenes_trabajo.controller;

import com.concesionario.ordenes_trabajo.entity.Vehicle;
import com.concesionario.ordenes_trabajo.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleControllerTest {

    private VehicleService vehicleService;
    private VehicleController vehicleController;

    private Vehicle sampleVehicle;

    @BeforeEach
    void setUp() {
        vehicleService = mock(VehicleService.class);
        vehicleController = new VehicleController(vehicleService);

        sampleVehicle = new Vehicle();
        sampleVehicle.setId(1L);
        sampleVehicle.setPlate("ABC123");
        sampleVehicle.setBrand("Toyota");
        sampleVehicle.setModel("Corolla");
        sampleVehicle.setYear(2020);
        sampleVehicle.setWorkOrders(Collections.emptyList());
    }

    @Test
    void testCreateVehicle() {
        when(vehicleService.save(any(Vehicle.class))).thenReturn(sampleVehicle);

        ResponseEntity<Vehicle> response = vehicleController.create(sampleVehicle);

        assertEquals(201, response.getStatusCode().value());
        assertEquals(sampleVehicle, response.getBody());
    }

    @Test
    void testListVehicles() {
        when(vehicleService.getAll()).thenReturn(List.of(sampleVehicle));

        List<Vehicle> result = vehicleController.list();

        assertEquals(1, result.size());
        assertEquals("ABC123", result.get(0).getPlate());
    }

    @Test
    void testGetById() {
        when(vehicleService.getById(1L)).thenReturn(sampleVehicle);

        ResponseEntity<Vehicle> response = vehicleController.getById(1L);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(sampleVehicle, response.getBody());
    }

    @Test
    void testUpdateVehicle() {
        Vehicle updated = new Vehicle();
        updated.setId(1L);
        updated.setPlate("XYZ789");
        updated.setBrand("Honda");
        updated.setModel("Civic");
        updated.setYear(2021);
        updated.setWorkOrders(Collections.emptyList());

        when(vehicleService.update(eq(1L), any(Vehicle.class))).thenReturn(updated);

        ResponseEntity<Vehicle> response = vehicleController.update(1L, updated);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("XYZ789", response.getBody().getPlate());
    }

    @Test
    void testDeleteVehicle() {
        doNothing().when(vehicleService).delete(1L);

        ResponseEntity<Void> response = vehicleController.delete(1L);

        assertEquals(204, response.getStatusCode().value());
        assertNull(response.getBody());
    }
}

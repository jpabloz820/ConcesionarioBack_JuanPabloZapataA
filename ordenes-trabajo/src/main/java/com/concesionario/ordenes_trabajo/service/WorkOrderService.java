package com.concesionario.ordenes_trabajo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.concesionario.ordenes_trabajo.entity.Vehicle;
import com.concesionario.ordenes_trabajo.entity.WorkOrder;
import com.concesionario.ordenes_trabajo.repository.VehicleRepository;
import com.concesionario.ordenes_trabajo.repository.WorkOrderRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkOrderService {

    private final WorkOrderRepository workOrderRepository;
    private final VehicleRepository vehicleRepository;

    public WorkOrder createOrder(Long vehicleId, WorkOrder workOrder) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehículo no encontrado"));

        if (workOrderRepository.existsByVehicleIdAndStatus(vehicleId, WorkOrder.Status.ACTIVA)) {
            throw new IllegalStateException("El vehículo ya tiene una orden activa");
        }
        workOrder.setVehicle(vehicle);
        workOrder.setOrderDate(LocalDate.now());
        workOrder.setStatus(WorkOrder.Status.ACTIVA);
        return workOrderRepository.save(workOrder);
    }

    public List<WorkOrder> getByVehicle(Long vehicleId) {
        return workOrderRepository.findByVehicleId(vehicleId);
    }

    public WorkOrder finalizeOrder(Long orderId) {
        WorkOrder order = workOrderRepository.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Orden no encontrada"));

        if (order.getStatus() == WorkOrder.Status.FINALIZADA) {
            throw new IllegalStateException("La orden ya está finalizada");
        }

        order.setStatus(WorkOrder.Status.FINALIZADA);
        return workOrderRepository.save(order);
    }
}


package com.concesionario.ordenes_trabajo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.concesionario.ordenes_trabajo.entity.WorkOrder;
import com.concesionario.ordenes_trabajo.service.WorkOrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class WorkOrderController {

    private final WorkOrderService workOrderService;

    @PostMapping("/vehicle/{vehicleId}")
    public ResponseEntity<WorkOrder> createOrder(@PathVariable Long vehicleId, @RequestBody WorkOrder workOrder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workOrderService.createOrder(vehicleId, workOrder));
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<WorkOrder> listByVehicle(@PathVariable Long vehicleId) {
        return workOrderService.getByVehicle(vehicleId);
    }

    @PutMapping("/{orderId}/finalize")
    public ResponseEntity<WorkOrder> finalize(@PathVariable Long orderId) {
        return ResponseEntity.ok(workOrderService.finalizeOrder(orderId));
    }
}


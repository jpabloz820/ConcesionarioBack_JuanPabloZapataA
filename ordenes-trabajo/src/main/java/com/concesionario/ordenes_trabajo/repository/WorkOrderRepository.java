package com.concesionario.ordenes_trabajo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.concesionario.ordenes_trabajo.entity.WorkOrder;

public interface WorkOrderRepository extends JpaRepository <WorkOrder, Long>{
    List<WorkOrder> findByVehicleId(Long vehicleId);
    boolean existsByVehicleIdAndStatus(Long vehicleId, WorkOrder.Status status);
}

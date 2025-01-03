package com.cmms.workordermanagement.service;

import com.cmms.workordermanagement.model.WorkOrder;

import java.util.List;
import java.util.Optional;

public interface WorkOrderService {

    List<WorkOrder> getAllWorkOrders();

    Optional<WorkOrder> getWorkOrderById(Long id);

    WorkOrder createWorkOrder(WorkOrder workOrder);

    WorkOrder updateWorkOrder(Long id, WorkOrder workOrderDetails);

    void deleteWorkOrder(Long id);
}

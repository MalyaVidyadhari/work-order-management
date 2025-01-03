package com.cmms.workordermanagement.service.impl;

import com.cmms.workordermanagement.model.WorkOrder;
import com.cmms.workordermanagement.repository.WorkOrderRepository;
import com.cmms.workordermanagement.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Override
    public List<WorkOrder> getAllWorkOrders() {
        return workOrderRepository.findAll();
    }

    @Override
    public Optional<WorkOrder> getWorkOrderById(Long id) {
        return workOrderRepository.findById(id);
    }

    @Override
    public WorkOrder createWorkOrder(WorkOrder workOrder) {
        workOrder.setDateCreated(LocalDateTime.now());
        return workOrderRepository.save(workOrder);
    }

    @Override
    public WorkOrder updateWorkOrder(Long id, WorkOrder workOrderDetails) {
        WorkOrder workOrder = workOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
        workOrder.setDescription(workOrderDetails.getDescription());
        workOrder.setStatus(workOrderDetails.getStatus());
        workOrder.setDateEnded(workOrderDetails.getDateEnded());
        return workOrderRepository.save(workOrder);
    }

    @Override
    public void deleteWorkOrder(Long id) {
        workOrderRepository.deleteById(id);
    }
}

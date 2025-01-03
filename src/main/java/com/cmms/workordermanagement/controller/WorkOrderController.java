package com.cmms.workordermanagement.controller;


import com.cmms.workordermanagement.model.WorkOrder;
import com.cmms.workordermanagement.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @GetMapping
    public List<WorkOrder> getAllWorkOrders() {
        return workOrderService.getAllWorkOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> getWorkOrderById(@PathVariable Long id){
        WorkOrder workOrder = workOrderService.getWorkOrderById(id).orElseThrow(() -> new RuntimeException("WorkOrder not found"));
        return ResponseEntity.ok(workOrder);
    }

    @PostMapping
    public WorkOrder createWorkOrder(@RequestBody WorkOrder workOrder){
        return workOrderService.createWorkOrder(workOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> updateWorkOrder(@PathVariable Long id, @RequestBody WorkOrder workOrderDetails){
        WorkOrder updateWorkOrder = workOrderService.updateWorkOrder(id, workOrderDetails);
        return ResponseEntity.ok(updateWorkOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrder(@PathVariable Long id){
        workOrderService.deleteWorkOrder(id);
        return ResponseEntity.noContent().build();
    }

}

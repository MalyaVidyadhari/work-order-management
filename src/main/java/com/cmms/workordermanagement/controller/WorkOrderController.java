package com.cmms.workordermanagement.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workordermanagement")
public class WorkOrderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/order")
    public String getOrder(){ return "order number is : "+port;}


}

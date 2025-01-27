package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.CustomerInfo;
import com.tka.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
     CustomerService customerService;
    
    
    @PostMapping("add")
    public void insertCustomer(@RequestBody CustomerInfo customerInfo) {
        customerService.addCustomer(customerInfo); // Call the service layer
        System.out.println("Controller Layer: Customer processed: " + customerInfo);
    }
    
    @GetMapping("all")
    public ResponseEntity<List<CustomerInfo>> getAllCustomers() {
        List<CustomerInfo> customers = customerService.getAllCustomers(); 
        return new ResponseEntity<>(customers, HttpStatus.OK); 
    }

//    @PostMapping("add")
//    public  ResponseEntity<CustomerInfo> addCustomer(@RequestBody CustomerInfo customerInfo) {
//    	System.out.println(customerInfo);
//        CustomerInfo savedCustomer = customerService.saveCustomer(customerInfo); 
//        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED); 
//    }

//    @GetMapping("/all")
//    public  ResponseEntity<List<CustomerInfo>> getAllCustomers() {
//        List<CustomerInfo> customers = customerService.getAllCustomers(); 
//        return new ResponseEntity<>(customers, HttpStatus.OK); 
//    }
}



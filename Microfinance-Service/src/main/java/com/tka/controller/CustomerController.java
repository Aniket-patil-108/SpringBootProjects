package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Add new customer
    @PostMapping("add")
    public ResponseEntity<String> insertCustomer(@RequestBody CustomerInfo customerInfo) {
        customerService.addCustomer(customerInfo); // Call the service layer
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body("Customer added successfully: " + customerInfo.getCustomerName());
    }

    // Get all customers
    @GetMapping("all")
    public ResponseEntity<List<CustomerInfo>> getAllCustomers() {
        List<CustomerInfo> customers = customerService.getAllCustomers1(); 
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    // Update customer by ID
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable int id, @RequestBody CustomerInfo updatedCustomerInfo) {
        boolean isUpdated = customerService.updateCustomer(id, updatedCustomerInfo); // Call service layer
        if (isUpdated) {
            return ResponseEntity.ok("Customer updated successfully: " + updatedCustomerInfo.getCustomerName());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Customer not found with ID: " + id);
        }
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
        boolean isDeleted = customerService.deleteCustomer(id); // Call service layer
        if (isDeleted) {
            return ResponseEntity.ok("Customer deleted successfully with ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Customer not found with ID: " + id);
        }
    }
}

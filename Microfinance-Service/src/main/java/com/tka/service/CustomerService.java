package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.CustomerDao;
import com.tka.entity.CustomerInfo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	// Fetch all customers
    public List<CustomerInfo> getAllCustomers1() {
        return customerDao.findAll(); // Delegate to DAO
    }

	// Add a new customer
	public void addCustomer(CustomerInfo customerInfo) {
		CustomerInfo savedCustomer = customerDao.save(customerInfo);
		System.out.println("Service Layer: Saved Customer: " + savedCustomer);
	}

	// Update customer by ID
	public boolean updateCustomer(int customerId, CustomerInfo updatedCustomerInfo) {
		return customerDao.updateCustomer(customerId, updatedCustomerInfo); // Delegate to DAO
	}
	
	// Delete customer by ID
    public boolean deleteCustomer(int id) {
        return customerDao.deleteCustomer(id); // Delegate to DAO layer
    }
}

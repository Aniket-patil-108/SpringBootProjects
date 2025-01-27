package com.tka.service;

import java.util.ArrayList;
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
	 public void addCustomer(CustomerInfo customerInfo) {
	        CustomerInfo savedCustomer = customerDao.save(customerInfo);
	        System.out.println("Service Layer: Saved Customer: " + savedCustomer);
	    }



//	public List<CustomerInfo> getAllCustomers() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

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
	
	

//	 public List<CustomerInfo> getAllCustomers() {
//	        return customerDao.findAll(); 
//	    }

	 public void addCustomer(CustomerInfo customerInfo) {
	        CustomerInfo savedCustomer = customerDao.save(customerInfo);
	        System.out.println("Service Layer: Saved Customer: " + savedCustomer);
	    }

}

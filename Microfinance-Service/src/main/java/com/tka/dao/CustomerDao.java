package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.CustomerInfo;


@Repository
public class CustomerDao {
	
	
	@Autowired
	 SessionFactory factory;

//	public List<CustomerInfo> findAll() {
//        Session session = factory.openSession();
//        session.beginTransaction();
//        List<CustomerInfo> customers = session.createQuery("FROM CustomerInfo", CustomerInfo.class).list();
//        session.getTransaction().commit();
//        session.close();
//        return customers;
//    }
	

	 public CustomerInfo save(CustomerInfo customerInfo) {
	        Session session = factory.openSession();
	        session.beginTransaction(); // Start a transaction
	        session.save(customerInfo); // Save the customer
	        session.getTransaction().commit(); // Commit the transaction
	        session.close(); // Close the session
	        return customerInfo; // Return the saved customer
	    }
		
		
	}
	
	
	



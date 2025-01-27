package com.tka.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.CustomerInfo;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory factory;

    // Find all customers
    public List<CustomerInfo> findAll() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<CustomerInfo> customers = session.createQuery("FROM CustomerInfo", CustomerInfo.class).list();
        session.getTransaction().commit();
        session.close();
        return customers;
    }

    // Save a new customer
    public CustomerInfo save(CustomerInfo customerInfo) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(customerInfo); // Save the customer
        session.getTransaction().commit();
        session.close();
        return customerInfo;
    }

    // Update customer by ID
    public boolean updateCustomer(int customerId, CustomerInfo updatedCustomerInfo) {
        Session session = factory.openSession();
        session.beginTransaction();
        
        // Retrieve the customer by ID
        CustomerInfo customer = session.get(CustomerInfo.class, customerId);
        
        if (customer != null) {
            // Update fields with new values
            customer.setCustomerName(updatedCustomerInfo.getCustomerName());
            customer.setAccountNumber(updatedCustomerInfo.getAccountNumber());
            customer.setCustomerBalance(updatedCustomerInfo.getCustomerBalance());
            customer.setCustomerLoanType(updatedCustomerInfo.getCustomerLoanType());

            // Save the updated customer
            session.update(customer);
            session.getTransaction().commit();
            session.close();
            return true; // Update successful
        }
        
        session.close();
        return false; // Customer not found
    }
    
    public boolean deleteCustomer(int id) {
        Session session = factory.openSession();
        session.beginTransaction();
        CustomerInfo customer = session.get(CustomerInfo.class, id);
        if (customer != null) {
            session.delete(customer); // Delete the customer if found
            session.getTransaction().commit(); // Commit the transaction
            session.close();
            return true; // Customer deleted
        }
        session.close();
        return false; // Customer not found
    }
}

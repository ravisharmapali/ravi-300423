package com.avisys.cim.services;

import java.util.List;

import com.avisys.cim.entities.Customer;

public interface ICustomerServices {

	List<Customer> getAllCustomers();

	Customer getCustomerByMobile(String mobNum);

	List<Customer> searchByFirstName(String keyword);

	List<Customer> searchByLastName(String keyword);
	
	// to create new customer 
	Customer createNewCustomer(Customer customer);
	
	// 	to delete customer	
	void deleteCustomer(String mobile);

}
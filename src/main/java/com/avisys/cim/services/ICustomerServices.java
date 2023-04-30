package com.avisys.cim.services;

import java.util.List;

import com.avisys.cim.entities.Customer;

public interface ICustomerServices {

	List<Customer> getAllCustomers();

	Customer getCustomerByMobile(String mobNum);

	List<Customer> searchByFirstName(String keyword);

	List<Customer> searchByLastName(String keyword);

}
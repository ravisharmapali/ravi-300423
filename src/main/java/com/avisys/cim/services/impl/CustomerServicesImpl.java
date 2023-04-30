package com.avisys.cim.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.entities.Customer;
import com.avisys.cim.repositories.CustomerRepo;
import com.avisys.cim.services.ICustomerServices;

@Service
public class CustomerServicesImpl implements ICustomerServices {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomers() {

		List<Customer> findAll = customerRepo.findAll();

		return findAll;
	}

	@Override
	public Customer getCustomerByMobile(String mobNum) {
		Customer customer = customerRepo.findByMobileNumber(mobNum).get();
		return customer;
	}

	@Override
	public List<Customer> searchByFirstName(String keyword) {

		List<Customer> searchByFirstName = customerRepo.searchByFirstName(keyword);

		return searchByFirstName;
	}

	@Override
	public List<Customer> searchByLastName(String keyword) {

		List<Customer> searchByLastName = customerRepo.searchByLastName(keyword);
		return searchByLastName;
	}
}
package com.avisys.cim.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.entities.Customer;
import com.avisys.cim.services.ICustomerServices;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	@Autowired
	private ICustomerServices customerServices;

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomers() {

		return ResponseEntity.ok(customerServices.getAllCustomers());
	}

	@GetMapping("/search/firstName/{keywords}")
	public ResponseEntity<List<Customer>> searchCustomerByFirstName(@PathVariable String keywords) {
		List<Customer> searchCustomers = this.customerServices.searchByFirstName(keywords);
		return new ResponseEntity<List<Customer>>(searchCustomers, HttpStatus.OK);
	}

	@GetMapping("/search/lastName/{keywords}")
	public ResponseEntity<List<Customer>> searchCustomerByLastName(@PathVariable String keywords) {
		List<Customer> searchCustomers = this.customerServices.searchByLastName(keywords);
		return new ResponseEntity<List<Customer>>(searchCustomers, HttpStatus.OK);
	}

	@GetMapping("/search/{mobNum}")
	public ResponseEntity<Customer> getCustomerUsingMobile(@PathVariable String mobNum) {
		return ResponseEntity.ok(customerServices.getCustomerByMobile(mobNum));
	}

}

package com.avisys.cim.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// user story 2:

	@PostMapping("/")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		System.out.println("inside controller method");
		Customer createNewCustomer = customerServices.createNewCustomer(customer);
		if (createNewCustomer == null) {
			return new ResponseEntity(Map.of("message", "Unable to create Customer. Mobile number already present."),
					HttpStatus.INTERNAL_SERVER_ERROR);

		} else {
			return new ResponseEntity<Customer>(createNewCustomer, HttpStatus.CREATED);
		}

	}

// to deleter a customer	
	@DeleteMapping("/{mobNum}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("mobNum") String mobile) {
		customerServices.deleteCustomer(mobile);
		//
		return new ResponseEntity(Map.of("message", "Customer deleted successfully"), HttpStatus.OK);
	}

	// to update existing customer
	@PutMapping("/{mobNum}")
	public ResponseEntity<Customer> updateUser(@Validated @RequestBody Customer customer, @PathVariable String mobNum ) {

		Customer updatedCustomer = customerServices.updateCustomer(customer, mobNum);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	
}

package com.avisys.cim.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.avisys.cim.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByMobileNumber(String mobileNumber);

	@Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :key, '%'))")
	List<Customer> searchByFirstName(@Param("key") String firstName);

	@Query("SELECT c FROM Customer c WHERE LOWER(c.lastName) LIKE LOWER(CONCAT('%', :key, '%'))")
	List<Customer> searchByLastName(@Param("key") String lastName);

}

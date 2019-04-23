package com.verizon.magento.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.magento.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	@Override
	Optional<Customer> findById(String email);

}

package com.verizon.magento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.verizon.magento.dto.CustomerDTO;
import com.verizon.magento.mapper.CustomerMapper;
import com.verizon.magento.model.Customer;
import com.verizon.magento.repositories.CustomerRepository;

@Configuration
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	CustomerMapper mapper;

	@Override
	public boolean saveCustomer(CustomerDTO customerDTO) {

		if (retrieveCustomer(customerDTO.getEmail()) == null) {
			customerRepo.save(mapper.mapDTOtoObject(customerDTO));
			return true;
		}

		return false;
	}

	@Override
	public Customer retrieveCustomer(String email) {

		return customerRepo.findById(email).orElse(null);

	}

}
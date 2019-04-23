package com.verizon.magento.mapper;

import org.springframework.stereotype.Component;

import com.verizon.magento.dto.CustomerDTO;
import com.verizon.magento.model.Customer;
import com.verizon.magento.util.Utility;

@Component
public class CustomerMapper {

	public Customer mapDTOtoObject(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		customer.setEmail(customerDTO.getEmail());
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setMiddleName(customerDTO.getMiddleName());
		customer.setSubscribe(customerDTO.isSubscribe());
		customer.setPassword(Utility.hashPassword(customerDTO.getPassword()));

		return customer;
	}

}

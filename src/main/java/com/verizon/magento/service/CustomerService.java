package com.verizon.magento.service;

import com.verizon.magento.dto.CustomerDTO;
import com.verizon.magento.model.Customer;

public interface CustomerService {

	boolean saveCustomer(CustomerDTO customerDTO);

	Customer retrieveCustomer(String email);

}

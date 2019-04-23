package com.verizon.magento.controller;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.magento.dto.CustomerDTO;
import com.verizon.magento.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(tags = "Magento Customer API")
public class ResourceController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "customer")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	@CrossOrigin(origins = "http://localhost:3000")
	@ApiOperation(value = "Adding Customer", notes = "Email ID should be Unique")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {

		boolean saveSuccesfull = customerService.saveCustomer(customerDTO);

		if (saveSuccesfull) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.header("Registration-Success", "Account creation successful").body(customerDTO);
		}

		return ResponseEntity.status(HttpStatus.CONFLICT).header("Registration-Failure", "Duplicate Email ID")
				.body(null);

	}
}

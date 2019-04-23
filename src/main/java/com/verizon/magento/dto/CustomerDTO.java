package com.verizon.magento.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

public class CustomerDTO {

	@Id
	@NotBlank(message = "This is a required field.")
	@Email(message = "Invalid email address.")
	private String email;
	@NotBlank(message = "This is a required field.")
	private String firstName;
	@NotBlank(message = "This is a required field.")
	private String lastName;
	@NotBlank(message = "This is a required field.")
	private String password;
	private String middleName;
	private boolean subscribe;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

package com.example.bankingapplication.model;

import java.util.Set;

import com.example.bankingapplication.entity.CustomerAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerModel {
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNumber;
	private String email;
	private String address;
	private String bloodGroup;
	private String aadharCardNumber;
    private String userName;
    private String password;
	private Set<CustomerAccount> customerAccount;
}

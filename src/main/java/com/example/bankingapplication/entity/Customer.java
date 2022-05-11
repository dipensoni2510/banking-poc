package com.example.bankingapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends BaseEntity {
    
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "aadhar_card_number")
	private String aadharCardNumber;
	
	@Column(name = "username", unique = true)
    private String userName;
    
	@Column(name = "password")
    private String password;
	
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
//	@JsonIgnore
	private List<CustomerAccount> customerAccount = new ArrayList<CustomerAccount>();
}

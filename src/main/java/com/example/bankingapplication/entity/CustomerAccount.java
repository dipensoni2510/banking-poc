package com.example.bankingapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="customer_account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerAccount extends CommonPropertyEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
	@JsonIgnore
	private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
	
	@Column(name = "account_number", nullable=false)
	private String accountNumber;
	
	@Column(name = "account_type", nullable=false)
	private String accountType;
	
	@Column(name="account_status")
	private String accountStatus;
	
	@Column(name="account_balance")
	private String accountBalance;
	
	@OneToMany(mappedBy="customerAccountFrom", fetch=FetchType.EAGER)
//	@JsonIgnore
	private List<Transection> transections = new ArrayList<Transection>();
	
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "customerAccountTo")
//	@JsonIgnore
	private Transection transection;
	
}

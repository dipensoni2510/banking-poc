package com.example.bankingapplication.model;

import java.util.Date;

import com.example.bankingapplication.entity.CustomerAccount;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransectionModel {
	private Integer id;
	private CustomerAccount customerAccountFrom;
	private CustomerAccount customerAccountTo;
	private String amount;
	private String comment;
	private Date transectionOn;
	private Boolean isTransectionSuccess;
}
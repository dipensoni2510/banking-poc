package com.example.bankingapplication.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="transection")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transection extends CommonPropertyEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="from_id")
	@JsonIgnore
	private CustomerAccount customerAccountFrom;
	
//	@OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="to_id")
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_id")
	private CustomerAccount customerAccountTo;
	
	@Column(name = "amount")
	private String amount;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "transection_on")
	private Date transectionOn;
	
	@Column(name = "transection_status")
	private Boolean isTransectionSuccess;
}

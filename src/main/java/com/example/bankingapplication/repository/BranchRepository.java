package com.example.bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankingapplication.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer> {
	
}

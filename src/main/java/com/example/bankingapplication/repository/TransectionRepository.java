package com.example.bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bankingapplication.entity.Transection;

@Repository
public interface TransectionRepository extends JpaRepository<Transection, Integer> {

}

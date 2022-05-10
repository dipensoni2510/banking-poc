package com.example.bankingapplication.service;

import java.util.List;

import com.example.bankingapplication.model.TransectionModel;

public interface TransectionService {

	TransectionModel saveTransection(TransectionModel transectionModel);

	List<TransectionModel> getAllTransections();

	TransectionModel getTransectionById(Integer id);

}

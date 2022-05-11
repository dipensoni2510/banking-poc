package com.example.bankingapplication.mapper;

import java.util.List;

import com.example.bankingapplication.entity.Transaction;
import org.mapstruct.Mapper;

import com.example.bankingapplication.model.TransectionModel;

@Mapper(componentModel = "spring")
public interface TransectionMapper {

	TransectionModel transectionToTransectionModel(Transaction transaction);
	Transaction transectionModelToTransection(TransectionModel transectionModel);
	List<TransectionModel> transectionListToTransectionModelList(List<Transaction> transactions);
	
}

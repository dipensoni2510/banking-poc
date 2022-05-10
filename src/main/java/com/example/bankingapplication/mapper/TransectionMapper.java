package com.example.bankingapplication.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.bankingapplication.entity.Transection;
import com.example.bankingapplication.model.TransectionModel;

@Mapper(componentModel = "spring")
public interface TransectionMapper {

	TransectionModel transectionToTransectionModel(Transection transection);
	Transection transectionModelToTransection(TransectionModel transectionModel);
	List<TransectionModel> transectionListToTransectionModelList(List<Transection> transections);
	
}

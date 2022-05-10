package com.example.bankingapplication.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.Transection;
import com.example.bankingapplication.mapper.TransectionMapper;
import com.example.bankingapplication.model.TransectionModel;
import com.example.bankingapplication.repository.TransectionRepository;
import com.example.bankingapplication.service.TransectionService;

@Service
public class TransectionServiceImpl implements TransectionService {

	private final TransectionRepository transectionRepository;
	private final TransectionMapper transectionMapper;
	
	public TransectionServiceImpl(TransectionRepository transectionRepository, 
			TransectionMapper transectionMapper) {
		this.transectionRepository = transectionRepository;
		this.transectionMapper = transectionMapper;
	}
	
	@Override
	public TransectionModel saveTransection(TransectionModel transectionModel) {
		transectionModel.setTransectionOn(new Date());
		transectionModel.setIsTransectionSuccess(true);
		Transection transection = transectionMapper.transectionModelToTransection(transectionModel);
		transection = transectionRepository.save(transection);
		return transectionMapper.transectionToTransectionModel(transection);
	}
	
	@Override
	public List<TransectionModel> getAllTransections() {
		List<Transection> transections = transectionRepository.findAll();
		return transectionMapper.transectionListToTransectionModelList(transections);
	}
	
	@Override
	public TransectionModel getTransectionById(Integer id) {
		return transectionMapper.transectionToTransectionModel(transectionRepository.findById(id).get());
	}
}

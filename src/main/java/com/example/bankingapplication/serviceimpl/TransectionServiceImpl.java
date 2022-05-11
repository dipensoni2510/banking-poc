package com.example.bankingapplication.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bankingapplication.entity.Transaction;
import com.example.bankingapplication.mapper.TransectionMapper;
import com.example.bankingapplication.model.TransectionModel;
import com.example.bankingapplication.repository.TransactionRepository;
import com.example.bankingapplication.service.TransectionService;

@Service
public class TransectionServiceImpl implements TransectionService {

	private final TransactionRepository transactionRepository;
	private final TransectionMapper transectionMapper;
	
	public TransectionServiceImpl(TransactionRepository transactionRepository,
                                  TransectionMapper transectionMapper) {
		this.transactionRepository = transactionRepository;
		this.transectionMapper = transectionMapper;
	}
	
	@Override
	public TransectionModel saveTransection(TransectionModel transectionModel) {
		transectionModel.setTransectionOn(new Date());
		transectionModel.setIsTransectionSuccess(true);
		Transaction transaction = transectionMapper.transectionModelToTransection(transectionModel);
		transaction = transactionRepository.save(transaction);
		return transectionMapper.transectionToTransectionModel(transaction);
	}
	
	@Override
	public List<TransectionModel> getAllTransections() {
		List<Transaction> transactions = transactionRepository.findAll();
		return transectionMapper.transectionListToTransectionModelList(transactions);
	}
	
	@Override
	public TransectionModel getTransectionById(Integer id) {
		return transectionMapper.transectionToTransectionModel(transactionRepository.findById(id).get());
	}
}

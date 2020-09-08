package com.springbootvuejs.backend.service;

import java.util.List;

import com.springbootvuejs.backend.entity.Transaction;

public interface TransactionEntityService {

	public List<Transaction> findAll();
	
	public Transaction findById(int theId);
	
	public Transaction save(Transaction transaction);
	
	public void deleteById(int theId);
	
}

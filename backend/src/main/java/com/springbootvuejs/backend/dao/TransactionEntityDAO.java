package com.springbootvuejs.backend.dao;

import java.util.List;

import com.springbootvuejs.backend.entity.Transaction;

public interface TransactionEntityDAO {

	public List<Transaction> findAll();
	
	public Transaction findById(int theId);
	
	public void save(Transaction transaction);
	
	public void deleteById(int theId);
	
}

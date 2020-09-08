package com.springbootvuejs.backend.rest;

import java.util.List;

import com.springbootvuejs.backend.entity.Transaction;
import com.springbootvuejs.backend.service.TransactionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api")
public class TransactionRestController {

	private TransactionEntityService transactionEntityService;

	@Autowired
	public TransactionRestController(TransactionEntityService theTransactionEntityService) {
		transactionEntityService = theTransactionEntityService;
	}
	
	// expose "/transactions" and return list of transactions
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("/transactions")
	public List<Transaction> findAll() {
		return transactionEntityService.findAll();
	}

	// add mapping for GET /transactions/{employeeId}
	
	@GetMapping("/transactions/{employeeId}")
	public Transaction getTransactionEntity(@PathVariable Integer employeeId) {
		
		Transaction theTransaction = transactionEntityService.findById(employeeId);
		
		if (theTransaction == null) {
			throw new RuntimeException("Transaction id not found - " + employeeId);
		}
		
		return theTransaction;
	}
	
	// add mapping for POST /transactions - add new transaction
	
	@PostMapping("/transactions")
	public Transaction addTransactionEntity(@RequestBody Transaction theTransaction, HttpServletResponse response) {
		
		Transaction savedTransaction = transactionEntityService.save(theTransaction);

		if (savedTransaction == null) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		} else {
			response.setStatus(HttpServletResponse.SC_CREATED);
		}
		return savedTransaction;
	}
	
	// add mapping for PUT /transactions - update existing employee
	
	@PutMapping("/transactions")
	public Transaction updateTransactionEntity(@RequestBody Transaction theTransaction) {
		
		transactionEntityService.save(theTransaction);
		
		return theTransaction;
	}
	
	// add mapping for DELETE /transactions/{employeeId} - delete employee
	
	@DeleteMapping("/transactions/{employeeId}")
	public String deleteTransactionEntity(@PathVariable int employeeId) {
		
		Transaction tempTransaction = transactionEntityService.findById(employeeId);
		
		// throw exception if null
		
		if (tempTransaction == null) {
			throw new RuntimeException("Transaction id not found - " + employeeId);
		}
		
		transactionEntityService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}











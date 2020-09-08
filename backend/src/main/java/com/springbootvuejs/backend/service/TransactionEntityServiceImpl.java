package com.springbootvuejs.backend.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import com.springbootvuejs.backend.dao.TransactionEntityDAO;
import com.springbootvuejs.backend.entity.Transaction;
import com.springbootvuejs.backend.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionEntityServiceImpl implements TransactionEntityService {

  private TransactionEntityDAO transactionEntityDAO;
  @Autowired
  private UserAccountService userAccountService;

  @Autowired
  public TransactionEntityServiceImpl(TransactionEntityDAO theTransactionEntityDAO) {
    transactionEntityDAO = theTransactionEntityDAO;
  }

  @Override
  @Transactional
  public List<Transaction> findAll() {
    List<Transaction> transactions = transactionEntityDAO.findAll();
    transactions.sort(Comparator.comparing(Transaction::getEffectiveDate).reversed());
    return transactions;
  }

  @Override
  @Transactional
  public Transaction findById(int theId) {
    return transactionEntityDAO.findById(theId);
  }

  @Override
  @Transactional
  public Transaction save(Transaction transaction) {

    UserAccount userAccount = userAccountService.findOne();
    if (userAccount != null && userAccount.getBalance() != null) {
      Integer balanceAfterTransaction = userAccount.getBalance() - transaction.getAmount();
      if (balanceAfterTransaction >= 0) {
        userAccount.setBalance(balanceAfterTransaction);
        userAccountService.save(userAccount);
        transaction.setEffectiveDate(LocalDateTime.now());
        transactionEntityDAO.save(transaction);
        return transaction;
      }
    }
    return null;
  }

  @Override
  @Transactional
  public void deleteById(int theId) {
    transactionEntityDAO.deleteById(theId);
  }

}







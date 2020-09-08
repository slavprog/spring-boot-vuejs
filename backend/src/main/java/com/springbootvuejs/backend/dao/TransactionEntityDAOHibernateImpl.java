package com.springbootvuejs.backend.dao;

import com.springbootvuejs.backend.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransactionEntityDAOHibernateImpl implements TransactionEntityDAO {

  // define field for entitymanager	
  private EntityManager entityManager;

  // set up constructor injection
  @Autowired
  public TransactionEntityDAOHibernateImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }


  @Override
  public List<Transaction> findAll() {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // create a query
    Query<Transaction> theQuery =
        currentSession.createQuery("from Transaction", Transaction.class);

    // execute query and get result list
    List<Transaction> employees = theQuery.getResultList();

    // return the results		
    return employees;
  }


  @Override
  public Transaction findById(int theId) {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // get the employee
    Transaction theTransaction =
        currentSession.get(Transaction.class, theId);

    // return the employee
    return theTransaction;
  }


  @Override
  public void save(Transaction theTransaction) {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // save employee
    currentSession.saveOrUpdate(theTransaction);
  }


  @Override
  public void deleteById(int theId) {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // delete object with primary key
    Query theQuery =
        currentSession.createQuery(
            "delete from Transaction where id=:employeeId");
    theQuery.setParameter("employeeId", theId);

    theQuery.executeUpdate();
  }

}








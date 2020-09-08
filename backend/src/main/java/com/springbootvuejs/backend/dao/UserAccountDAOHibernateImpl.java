package com.springbootvuejs.backend.dao;

import com.springbootvuejs.backend.entity.UserAccount;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserAccountDAOHibernateImpl implements UserAccountDAO {

  // define field for entitymanager
  private EntityManager entityManager;

  // set up constructor injection
  @Autowired
  public UserAccountDAOHibernateImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }


  @Override
  public List<UserAccount> findAll() {

    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // create a query
    Query<UserAccount> theQuery =
        currentSession.createQuery("from UserAccount", UserAccount.class);

    // execute query and get result list
    List<UserAccount> userAccounts = theQuery.getResultList();

    // return the results		
    return userAccounts;
  }

  @Override public void save(UserAccount userAccount) {
    // get the current hibernate session
    Session currentSession = entityManager.unwrap(Session.class);

    // save employee
    currentSession.saveOrUpdate(userAccount);
  }

}








package com.springbootvuejs.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account")

public class UserAccount {
  @Id
  @GeneratedValue
  @Column(name="id")
  private int id;
  @Column(name="first_name")
  private String firstName;
  @Column(name="last_name")
  private String lastName;
  @Column(name="balance")
  private Integer balance;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getBalance() {
    return balance;
  }

  public void setBalance(Integer balance) {
    this.balance = balance;
  }

  public UserAccount(String firstName, String lastName, Integer balance) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.balance = balance;
  }

  public UserAccount() {
  }
}

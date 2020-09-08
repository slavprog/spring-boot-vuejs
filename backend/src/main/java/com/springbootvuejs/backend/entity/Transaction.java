package com.springbootvuejs.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="transaction")

public class Transaction {
  @Id
  @GeneratedValue
  @Column(name="id")
  private Integer id;
  @Column(name="type")
  private String type;
  @Column(name="amount")
  private Integer amount;
  @Column(name="effective_date")
  private LocalDateTime effectiveDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public LocalDateTime getEffectiveDate() {
    return effectiveDate;
  }

  public void setEffectiveDate(LocalDateTime effectiveDate) {
    this.effectiveDate = effectiveDate;
  }

  public Transaction(String type, Integer amount, LocalDateTime effectiveDate) {
    this.type = type;
    this.amount = amount;
    this.effectiveDate = effectiveDate;
  }

  public Transaction() {
  }
}

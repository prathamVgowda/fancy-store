package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
    @JoinColumn(name = "product_id", unique = true)
	private Products product;

	@Column(name = "balance")
	private Integer balance;

	@Column(name = "inward")
	private Integer inward;

	@Column(name = "outward")
	private Integer outward;

	@Column(name = "transaction_type")
	private TransactionType transactionType;

	public enum TransactionType {
		Sales, Restock, Return
	}

	public Stock() {
	}

	public Stock(Products product, Integer balance, Integer inward, Integer outward, TransactionType transactionType) {
		this.product = product;
		this.balance = balance;
		this.inward = inward;
		this.outward = outward;
		this.transactionType = transactionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getInward() {
		return inward;
	}

	public void setInward(Integer inward) {
		this.inward = inward;
	}

	public Integer getOutward() {
		return outward;
	}

	public void setOutward(Integer outward) {
		this.outward = outward;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
}

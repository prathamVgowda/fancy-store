package com.shop.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class StockDTO {

	private Long id;
	
	@NotNull(message = "Product is required")
    private Long productId;

    @NotNull(message = "Balance is required")
    @PositiveOrZero(message = "Balance cannot be negative")
    private Integer balance;

    @NotNull(message = "Inward is required")
    @PositiveOrZero(message = "Inward cannot be negative")
    private Integer inward;

    @NotNull(message = "Outward is required")
    @PositiveOrZero(message = "Outward cannot be negative")
    private Integer outward;
    
    @NotNull(message = "Transaction type is required")
    private String transactionType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
    
    
    
}

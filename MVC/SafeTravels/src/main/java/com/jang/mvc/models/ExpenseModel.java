package com.jang.mvc.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class ExpenseModel {

	
public ExpenseModel() {}





	public ExpenseModel(@NotBlank(message = "Name required") String expenseName,
		@NotBlank(message = "Vendor required") String vendor,
		@NotNull(message = "Price required") @Min(value = 0, message = "Please enter a valid amount.")  Integer amount,
		@NotBlank(message = "Description required") String descripiton) {
	super();
	this.expenseName = expenseName;
	this.vendor = vendor;
	this.amount = amount;
	this.descripiton = descripiton;
}





	//	MAIN SQL TABLE CONNECTION REQUIRMENTS
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
// Variable Members
    
	@NotBlank(message="Name required")
    private String expenseName;
    
	@NotBlank(message="Vendor required")
    private String vendor;
    
	@NotNull(message="Price required")
    @Min(value=0, message="Please enter a valid amount.")
    private Integer amount;
    
	@NotBlank(message="Description required")
    private String descripiton;
    
    
    // GETTERS AND SETTERS

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getDescripiton() {
		return descripiton;
	}
	public void setDescripiton(String descripiton) {
		this.descripiton = descripiton;
	}
}

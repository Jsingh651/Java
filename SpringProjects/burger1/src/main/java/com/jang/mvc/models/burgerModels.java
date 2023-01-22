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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class burgerModels {

	public burgerModels () {}
	
	
	public burgerModels(String burger_title, String restaurunt_title, Double ratings, String description) {
		this.burger_title = burger_title;
		this.restaurunt_title = restaurunt_title;
		this.ratings = ratings;
		this.description = description;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message = "Burger name must be at least 2 characters long")
	private String burger_title;
	
	@Size(min = 2, message = "Restaurant name must be at least 2 characters long")
	private String restaurunt_title;
	
	@Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 5, message = "Rating must be at most 5")
	private Double ratings;
	
	@Size(min = 10, message = "Description must be at least 10 characters long")
	private String description;
	

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBurger_title() {
		return burger_title;
	}


	public void setBurger_title(String burger_title) {
		this.burger_title = burger_title;
	}


	public String getRestaurunt_title() {
		return restaurunt_title;
	}


	public void setRestaurunt_title(String restaurunt_title) {
		this.restaurunt_title = restaurunt_title;
	}


	public Double getRatings() {
		return ratings;
	}


	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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





}

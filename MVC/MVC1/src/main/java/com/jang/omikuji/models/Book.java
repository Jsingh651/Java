package com.jang.omikuji.models;

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
import javax.validation.constraints.NotNull;

// Class
@Entity
@Table(name="books")
public class Book {
	
	// constructure
	public Book() {}
	
	public Book(String title,  String description, String language,  int num_of_pages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.num_of_pages = num_of_pages;
	}

	public Book(Long id, String title,  String description, String language,  int num_of_pages) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.num_of_pages = num_of_pages;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNum_of_pages() {
		return num_of_pages;
	}

	public void setNum_of_pages(int num_of_pages) {
		this.num_of_pages = num_of_pages;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String language;
	
	@NotNull
	@Min(value = 20000, message = "Need more pages")
	private int num_of_pages;

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
}

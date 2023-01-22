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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="languages")
public class LanguageModel {
	
	public LanguageModel() {}
	
	public LanguageModel(
			@Size(min = 3, message = "Must be at least 3 characters") @Size(max = 20, message = "Must be at less then 20 characters") String name,
			@Size(min = 3, message = "Must be at least 3 characters") @Size(max = 20, message = "Must be at less then 20 characters") String creator,
			@NotNull(message = "Version type should not be empty") Integer version) {
		super();
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

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
    
    @Size(min = 3, message="Must be at least 3 characters")
    @Size(max = 20, message="Must be at less then 20 characters")
    private String name;
    
    @Size(min = 3, message="Must be at least 3 characters")
    @Size(max = 20, message="Must be at less then 20 characters")
    private String creator;
    
    @NotNull(message = "Version type should not be empty")
    private Integer version;

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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	
}


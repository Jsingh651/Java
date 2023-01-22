package com.jang.ProductsAndCategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	
	

	public Project() {}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotEmpty(message="Title can't be empty")
	private String title;
	
	@Size(min= 3, message="Description can't be empty")
	private String description;
	
	
	@Future(message="Due date must be in the future")
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date due_date;
    
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

	@ManyToMany(fetch = FetchType.LAZY)
   	@JoinTable(
   			name = "team",
   			joinColumns = @JoinColumn(name="project_id"),
   			inverseJoinColumns = @JoinColumn(name = "member_id")
   			)
    private List<User> members;
	
	

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="lead_id")
    private User lead;
    
    @OneToMany(mappedBy="project_task", fetch=FetchType.LAZY)
    private List <Task> allTasks;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
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
	public User getLead() {
		return lead;
	}
	public void setLead(User lead) {
		this.lead = lead;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public List<Task> getAllTasks() {
		return allTasks;
	}
	public void setAllTasks(List<Task> allTasks) {
		this.allTasks = allTasks;
	}
    
    
}

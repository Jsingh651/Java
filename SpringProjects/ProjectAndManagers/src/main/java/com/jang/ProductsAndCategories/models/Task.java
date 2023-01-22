package com.jang.ProductsAndCategories.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="tasks")
public class Task {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Size(min=5, message = "Task can't be empty")
	private String taskDetails;
	
	 @Column(updatable=false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date createdAt;
	    
	    
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="task_creator_id")
	 private User task_creator;
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="task_project_id")
	 private Project project_task;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskDetails() {
		return taskDetails;
	}

	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getTask_creator() {
		return task_creator;
	}

	public void setTask_creator(User task_creator) {
		this.task_creator = task_creator;
	}

	public Project getProject_task() {
		return project_task;
	}

	public void setProject_task(Project project_task) {
		this.project_task = project_task;
	}
	 
	
	
}

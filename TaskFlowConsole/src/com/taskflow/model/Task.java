package com.taskflow.model;

import java.time.LocalDate;

public class Task {
	private int taskId;
	private String title;
	private String description;
	private Status status;
	private Priority priority;
	private LocalDate dueDate;
	private int assignedTo;
	private int projectId;
	
	public Task() {
		super();
	}
	public Task(String title, String description, Status status, Priority priority, LocalDate dueDate, int assignedTo,
			int projectId) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.projectId = projectId;
	}
	public Task(int taskId, String title, String description, Status status, Priority priority, LocalDate dueDate,
			int assignedTo, int projectId) {
		super();
		this.taskId = taskId;
		this.title = title;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.dueDate = dueDate;
		this.assignedTo = assignedTo;
		this.projectId = projectId;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public int getTaskId() {
		return taskId;
	}
	public int getProjectId() {
		return projectId;
	}
	
	public String toString() {
		return "Task [taskId= "+taskId+", title= "+title+", description= "+description+", status= "+status+", priority= "+priority+", dueDate= "+dueDate+", assignedTo= "+assignedTo
				+", projectId= "+projectId+"]";
		}
}

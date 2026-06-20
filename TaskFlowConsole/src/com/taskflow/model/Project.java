package com.taskflow.model;

public class Project {
	private int projectId;
	private String name;
	private String description;
	private int ownerId;
	
	public Project() {
		super();
	}
	public Project(String name, String description, int ownerId) {
		super();
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
	}
	public Project(int projectId, String name, String description, int ownerId) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.ownerId = ownerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProjectId() {
		return projectId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	
	public String toString() {
		return "Project [projectId= "+projectId+", name= "+name+", description= "+description+", Owner= "+ownerId+"]";
	}
	
}

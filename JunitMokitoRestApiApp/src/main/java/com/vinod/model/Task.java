package com.vinod.model;

public class Task {
	
	private Long id;
    private String name;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + "]";
	}
    

}

package com.pactera.spring.model;


public class Manager {
	//经理id
	private int id;
	private String name;
	private String position;
	private int age;
	//经理所在的部门id
	private int departmentId;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", position=" + position + ", age=" + age + ", departmentId="
				+ departmentId + "]";
	}
	
}

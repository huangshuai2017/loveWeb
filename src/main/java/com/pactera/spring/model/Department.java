package com.pactera.spring.model;

public class Department {
	private int id;
	//Finance Electronic Commerce
	private String name;
	private Manager projectManage;
	private Manager productManager;
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
	public Manager getProjectManage() {
		return projectManage;
	}
	public void setProjectManage(Manager projectManage) {
		this.projectManage = projectManage;
	}
	public Manager getProductManager() {
		return productManager;
	}
	public void setProductManager(Manager productManager) {
		this.productManager = productManager;
	}
	
}

package com.pactera.spring.model;

import java.util.List;

public class Department {
	private int id;
	//Finance Electronic Commerce
	private String name;
	private Manager projectManage;
	private Manager productManager;
	private List<Emp> empList;
	
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", projectManage=" + projectManage + ", productManager="
				+ productManager + ", empList=" + empList + "]";
	}
	
}

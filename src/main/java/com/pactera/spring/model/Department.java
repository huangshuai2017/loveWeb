package com.pactera.spring.model;

import java.util.List;

public class Department {
	//id
	private int id;
	//部门名 eg.software
	private String name;
	//项目经理
	private Manager projectManage;
	//产品经理
	private Manager productManager;
	//多名员工
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
		return "Department{" +
				"id=" + id +
				", name='" + name + '\'' +
				", projectManage=" + projectManage +
				", productManager=" + productManager +
				", empList=" + empList +
				'}';
	}
}

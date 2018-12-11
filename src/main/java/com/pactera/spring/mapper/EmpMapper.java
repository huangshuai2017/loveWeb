package com.pactera.spring.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pactera.spring.model.Emp;
public interface EmpMapper {

	void insertEmp(Emp emp);
	void insertEmpList(List<Emp> empList);

	Emp selectById(int id);
	List<Emp> selectAll();
}

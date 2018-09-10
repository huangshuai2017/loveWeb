package com.pactera.spring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pactera.spring.model.Emp;
public interface EmpMapper {
	List<Emp> selectByGender(String gender);
	void insertEmps(List<Emp> empList);
}

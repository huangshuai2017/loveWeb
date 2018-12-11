package com.pactera.spring.mapper;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pactera.spring.model.Department;

public class DepartmentMapperTest {

	@Test
	public void testSelectById() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-mvc.xml");
		System.out.println(ac);
		DepartmentMapper departmentMapper = ac.getBean(DepartmentMapper.class);
		Department department = departmentMapper.selectById(1);
		System.out.println(department);
	}

}

package com.pactera.spring.mapper;


import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pactera.spring.model.Department;

public class DepartmentMapperTest {

	@Test
	public void testSelectById() throws InterruptedException {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("spring-mvc.xml");
		System.out.println(ac);
		DepartmentMapper departmentMapper = ac.getBean(DepartmentMapper.class);
		Thread.sleep(1000);
		System.out.println("///////////////11111///////////////////////////");
		Department department = departmentMapper.selectById(1);
		System.out.println(department);
//		Thread.sleep(1000);
//		System.out.println("///////////////////22222///////////////////////");
//		System.out.println(department.getProductManager().getPosition());
//		Thread.sleep(1000);
//		System.out.println("////////////////////33333//////////////////////");
//		System.out.println(department.getProjectManage().getPosition());
	}

}

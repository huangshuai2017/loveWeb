package com.pactera.spring.dao;

import static org.junit.Assert.*;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.spring.model.Emp;
import com.pactera.spring.model.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml" })
public class EmpMapperTest {
	String mybatisConf = "config/mybatis-config.xml";
	SqlSession sqlSession;
	SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		System.out.println("测试初始化");
		Reader reader = Resources.getResourceAsReader(mybatisConf);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		sqlSession = sqlSessionFactory.openSession(true);
	}

//	@Test
	public void  testDelete() {
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		Emp emp = null;
		emp = new Emp();
		emp.setAge(16);
		empMapper.deleteAllByAge(emp);
	}
	@Test
	public void test() {
		System.out.println("测试test()");
		System.out.println(sqlSession);
		for (int j = 0; j < 100; j++) {
			List<Emp> eList = new ArrayList<>();
			
			Emp emp = null;
			for (int i = 0; i < 20000; i++) {

				emp = new Emp();
				emp.setAge(16);
				emp.setGender("m");
				emp.setName("sury" + i);
				eList.add(emp);
			}
			EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
			empMapper.insertEmps(eList);
		}
		
		// Emp emp1 = new Emp();
		// emp1.setAge(19);
		// emp1.setGender("f");
		// emp1.setName("jack");
		// eList.add(emp1);
		// sqlSession.insert("insertEmps", eList);
		// List<Emp> kk = sqlSession.selectList("selectByGender", "f");
		// EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		// empMapper.selectByGender("f");
		// Emp emp1 = new Emp();
		// emp1.setAge(20);
		// emp1.setGender("f");
		// emp1.setName("jack");
		// sqlSession.update("updateEmp", emp1);
		// sqlSession.close();
		// System.out.println(kk);
		// SqlSession s1 = sqlSessionFactory.openSession(true);
		//
		// s1.selectList("selectByGender", "f");
		// s1.update("updateEmp", emp1);
		// SqlSession s2 = sqlSessionFactory.openSession(true);
		//
		// s2.selectList("selectByGender", "f");
		// sqlSession.insert("insertEmp", new Emp("juli", "f", 18));
		// List<Emp> kk1 = sqlSession.selectList("selectByGender", "f");
		// List<Emp> kk1 = sqlSession.selectList("selectByAge", 12);
		// System.out.println(kk1);
	}

	// @Test
	public void testAddUser() {
		User user = new User();
		user.setPassword("123456");
		user.setUserName("jack");
		user.setDepartmentId(11);
		sqlSession.insert("insertUser", user);
		System.out.println(user.getUserId());
	}

	// @Test
	public void testSelectUseById() {
		User user = new User();
		user.setUserId(11);
		List<User> users = sqlSession.selectList("selectUserById", user);
		System.out.println(users);
	}

	// @After
	public void destroy() {
		if (sqlSession != null) {
			sqlSession.close();
		}

	}
}

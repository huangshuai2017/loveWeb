package spring002;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.spring.dao.EmpMapper;
import com.pactera.spring.model.Emp;
import com.pactera.spring.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mvc.xml" })
public class TestMybatis {

	String mybatisConf = "config/mybatis-config.xml";
	SqlSession sqlSession;

	@Before
	public void init() throws Exception {
		System.out.println("测试初始化");
		Reader reader = Resources.getResourceAsReader(mybatisConf);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		sqlSession = sqlSessionFactory.openSession(true);
	}

	@Test
	public void test() {
		System.out.println("测试test()");
		System.out.println(sqlSession);
//		List<Emp> eList = new ArrayList<>();
//		Emp emp = new Emp();
//		emp.setAge(16);
//		emp.setGender("m");
//		emp.setName("sury");
//		eList.add(emp);
//		Emp emp1 = new Emp();
//		emp1.setAge(19);
//		emp1.setGender("f");
//		emp1.setName("jack");
//		eList.add(emp1);
//		sqlSession.insert("insertEmps", eList);
		List<Emp> kk = sqlSession.selectList("selectByGender", "f");
		System.out.println(kk);
	}

//	@Test
	public void testAddUser() {
		User user = new User();
		user.setPassword("123456");
		user.setUserName("jack");
		user.setDepartmentId(11);
		sqlSession.insert("insertUser", user);
		System.out.println(user.getUserId());
	}

//	@Test
	public void testSelectUseById() {
		User user = new User();
		user.setUserId(11);
		List<User> users = sqlSession.selectList("selectUserById", user);
		System.out.println(users);
	}

	@After
	public void destroy() {
		if (sqlSession != null) {
			sqlSession.close();
		}

	}

}

package spring002;

import java.io.IOException;
import java.io.Reader;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.spring.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mvc.xml"})
public class TestMybatis {

	String mybatisConf = "config/mybatis-config.xml";
	SqlSession sqlSession;
	@Before
	public void init() throws Exception {
		System.out.println("测试初始化");
		Reader reader = Resources.getResourceAsReader(mybatisConf);
		SqlSessionFactory  sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(reader,"development");
		sqlSession = sqlSessionFactory.openSession(true);
	}
	@Test
	public void test() {
		System.out.println("测试test()");
		System.out.println(sqlSession);
	}
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setPassword("123456");
		user.setUserName("jack");
		user.setDepartmentId(11);
		sqlSession.insert("insertUser", user);
		System.out.println(user.getUserId());
	}
	@Test
	public   void testSelectUseById() {
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

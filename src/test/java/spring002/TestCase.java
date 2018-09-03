package spring002;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pactera.spring.interceptor.RequestInterceptor;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-mvc.xml"})
public class TestCase {

	@Test
	public  void test() {
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(cfg);
		System.out.println(ctx);
		RequestInterceptor RequestInterceptor 
		    = ctx.getBean(RequestInterceptor.class);
		System.out.println(RequestInterceptor);
	}
	
}


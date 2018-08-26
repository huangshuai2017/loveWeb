package spring002;

import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {

	@Ignore
	public  void test(String[] args) {
		String cfg = "spring-mvc.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(cfg);
		System.out.println(ctx);
	}
	
}


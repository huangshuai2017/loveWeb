package com.pactera.spring.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("TestListener contextInitialized");
		ServletContext sc = sce.getServletContext();
		System.out.println("ServletContext  :"+ sc);
		String kk = sc.getInitParameter("kkk");
		System.out.println(kk);
		Enumeration<String> enumeration = sc.getServletNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			System.out.println(string);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("TestListener contextDestroyed");
	}

}

package com.pactera.spring.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class TestServlet extends HttpServlet {
	public TestServlet() {
		super();
		System.out.println("TestServlet 执行构造函数");
	}
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("TestServlet init ...");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("TestServlet req....");
		ServletContext servletContext = getServletContext();
//		System.out.println(this.getClass().getSimpleName() + " servletContext:"+servletContext);
	}

}

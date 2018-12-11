package com.pactera.spring.controller;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.mvc.LastModified;

public class MyServlet extends HttpServlet{
	
	
	public MyServlet() {
		super();
		System.out.println("MyServlet 执行构造函数");
	}
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		System.out.println("MyServlet init ...");
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2471386444207404619L;
	private static Long count= -1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("MyServlet req....");
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {
			System.out.println("cookies is null");
		}else {
			Stream.of(cookies).forEach(System.out::println);
		}
		count= System.currentTimeMillis();
		resp.addCookie(new Cookie("uname", "jack"));
		ServletContext servletContext = getServletContext();
//		System.out.println(this.getClass().getSimpleName() + " servletContext:"+servletContext);
		resp.getWriter().write("hello" +count);
	}
	@Override
	public long getLastModified(HttpServletRequest req) {
        return count;
    }
}

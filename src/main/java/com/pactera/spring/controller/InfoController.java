package com.pactera.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

public class InfoController extends AbstractController implements LastModified{

	private static Long count= -1L;
	public String test() {
		return "hello";
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
		count= System.currentTimeMillis();
		response.getWriter().write("hello" +count);
		return null;
	}

	@Override
	public long getLastModified(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return count;
	}
	
}

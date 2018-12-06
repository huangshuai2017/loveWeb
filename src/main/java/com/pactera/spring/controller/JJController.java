package com.pactera.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.LastModified;

@RestController
@RequestMapping("/info")
public class JJController 
{
	private static Long count = 0L;

	@GetMapping("/jj")
	public String test(WebRequest request) {
		if(request.checkNotModified(count)) {
			return null;
		}
		System.out.println("******************************8");
		count = System.currentTimeMillis();
		return "hello";
	}

}

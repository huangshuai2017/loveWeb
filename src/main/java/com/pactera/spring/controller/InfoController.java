package com.pactera.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

	@GetMapping(value="/test/{id}")
	@ResponseBody
	public String test(@PathVariable(name="id") String id,HttpServletRequest request) {
		System.out.println("test " + id);
		String uri = request.getRequestURI();
		System.out.println(uri);
		return "test info";
	}
}

package com.pactera.spring.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pactera.spring.exception.NullParamException;
import com.pactera.spring.model.Paths;
import com.pactera.spring.model.User;
import com.pactera.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService userService;
	
	@Autowired
	
	Paths paths;
	
	@RequestMapping("/registry.form")
	public String registry(HttpServletRequest request, String username,String password) {
		System.out.println("接受请求");
		
		if(StringUtils.isEmpty(username) 
				|| StringUtils.isEmpty(password)) {
			throw new NullParamException("参数不能为空");
		}
		if(userService.checkUser(username, password)) {
			return "login";
		}
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		userService.insertUser(user);
		return "login";
	}
	@RequestMapping("/toRegistry.form")
	public String ToRegistry() {
		return "registry";
	}
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct");
	}
	
	@RequestMapping("/toPage.form")
	public String toLoginPage() {
		return "login";
	}
	
	@RequestMapping("/login.form")
	public String login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		if(StringUtils.isEmpty(username) 
				|| StringUtils.isEmpty(password)) {
			throw new NullParamException("登录参数不能为空");
		}
		String result = 
				userService.checkUser(username, password)?
						"loginSuccess":"loginFailure";
		return result;
	}
	
	@ResponseBody
	@GetMapping(value="/hi",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> sayHi() {
		return paths.includePaths;
	}
}

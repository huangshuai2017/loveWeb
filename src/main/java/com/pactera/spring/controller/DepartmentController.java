package com.pactera.spring.controller;

import com.pactera.spring.model.Department;
import com.pactera.spring.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	IDepartmentService departmentService;

	@GetMapping("/select")
	public String getDepartment(@RequestParam("id") int id) {
		departmentService.selectById(id);
		return "ok";
	}

	/**
	 * consumes-用来限制请求实体头域中的content-Type,只要请求中的实体头域content-Type头域值在consumes指定的类型中
	 * 则可以正常处理，否则会报406错误，406 Not Acceptable
	 * produces-用来限制请求头域中的Accept，只要该参数指定的值都不在请求头域中的Accept值中， 则报415错误，Unsupported
	 * Media Type；设置响应体中实体头域content-Type的作用 以上两处校验是在HandlerMapping中校验的
	 * 
	 * @param id
	 * @param city
	 * @param response
	 * @return
	 * @throws Exception
	 */

	@GetMapping(value = "/select/projM", consumes = "application/json", produces = { "text/html;charset=utf-8" })
	public String getDepartmentProjM(@RequestParam("id") int id) throws Exception {
		Department department = departmentService.selectById(id);
		System.out.println(department);
		return "查詢成功";
	}
}

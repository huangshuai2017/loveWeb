package com.pactera.spring.controller;

import com.pactera.spring.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/department")
public class DepartmentController {
@Autowired
    IDepartmentService departmentService;
    @GetMapping("/select")
    public String getDepartment(@RequestParam("id") int id){
        departmentService.selectById(id);
        return "ok";
    }
    @GetMapping("/select/projM")
    public String getDepartmentProjM(@RequestParam("id") int id, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        return departmentService.selectById(id).getProjectManage().getName();
    }
}

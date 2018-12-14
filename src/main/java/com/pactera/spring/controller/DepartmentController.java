package com.pactera.spring.controller;

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

    //text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*
    //consumes-当前的accept用来指定当前处理器的接受请求的类型，
    //同时也起到了过滤请求的请求头中content-type的作用, 不匹配的时候请求端会收到406 Not Acceptable
    //produces-当前的content-type用来指定当前处理器的body体中的消息类型，
    //同时也起到了过滤请求的请求头中accept头的作用 不匹配的时候请求端会收到415 – Unsupported Media Type
    @GetMapping(value = "/select/projM", consumes = "application/json", produces = {"text/html"})
    public String getDepartmentProjM(@RequestParam("id") int id, @RequestParam("city") String city,
                                   HttpServletResponse response
    ) throws Exception {
        System.out.println("city:" + city);
        //charset=utf-8
//        response.setContentType("application/json");
//        response.getWriter().write(departmentService.selectById(id).getProjectManage().getName());
        return departmentService.selectById(id).getProjectManage().getName();
    }
}

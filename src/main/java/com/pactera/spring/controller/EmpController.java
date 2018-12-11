package com.pactera.spring.controller;

import com.pactera.spring.model.Emp;
import com.pactera.spring.service.IEmpservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class EmpController {

    @Autowired
    IEmpservice empservice;
    @RequestMapping("/save")
    public String insert() throws CloneNotSupportedException {
        Emp emp = new Emp();
        emp.setAge(23);
        emp.setGender("f");
        emp.setName("jack");
        empservice.insert(emp);
//        List<Emp> empList = new ArrayList<>();
//        empList.add(emp);
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());
//        empList.add(emp.clone());

//        empservice.insertEmpList(empList);

        return "ok";
    }
}

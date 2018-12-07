package com.pactera.spring.service.impl;

import com.pactera.spring.mapper.EmpMapper;
import com.pactera.spring.model.Emp;
import com.pactera.spring.service.IEmpservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpservice{
    @Autowired
    EmpMapper empMapper;
    @Override
    public void insert(Emp emp) {
        empMapper.insertEmp(emp);
    }
}

package com.pactera.spring.service.impl;

import com.pactera.spring.mapper.EmpMapper;
import com.pactera.spring.model.Emp;
import com.pactera.spring.service.IEmpservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService implements IEmpservice{
    @Autowired
    EmpMapper empMapper;
    @Override
    public void insert(Emp emp) {
        empMapper.insertEmp(emp);
    }

    @Override
    public void insertEmpList(List<Emp> empList) {
        empMapper.insertEmpList(empList);
    }

    @Override
    public Emp selectById(int id) {
        return empMapper.selectById(id);
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }
}

package com.pactera.spring.service.impl;

import com.pactera.spring.mapper.DepartmentMapper;
import com.pactera.spring.model.Department;
import com.pactera.spring.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public Department selectById(int id) {
        return departmentMapper.selectById(id);
    }
}

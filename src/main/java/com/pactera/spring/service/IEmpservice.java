package com.pactera.spring.service;

import com.pactera.spring.model.Emp;

import java.util.List;

public interface IEmpservice {
    void insert(Emp emp);
    void insertEmpList(List<Emp> empList);
}

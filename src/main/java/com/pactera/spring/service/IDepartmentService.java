package com.pactera.spring.service;

import com.pactera.spring.model.Department;

public interface IDepartmentService {
    Department selectById(int id);
}

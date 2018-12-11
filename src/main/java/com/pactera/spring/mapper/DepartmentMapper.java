package com.pactera.spring.mapper;

import com.pactera.spring.model.Department;

public interface DepartmentMapper {
	Department selectById(int id);
}

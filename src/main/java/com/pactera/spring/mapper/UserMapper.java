package com.pactera.spring.mapper;

import java.util.List;

import com.pactera.spring.model.Department;
import com.pactera.spring.model.User;

public interface UserMapper {

	int insertUser(User user);
	User selectUserById(int userId);
	Department selectDepartment(int department_id);
}

package com.pactera.spring.dao;

import com.pactera.spring.model.Role;

public interface RoleMapper {

	int addRole(Role role);
	Role selectRoleByName(String roleName);
}

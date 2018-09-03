package com.pactera.spring.model;


public class Role {
	private int roleId;
	
    private String roleName;

    private int userId;

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRole_id() {
        return roleId;
    }

    public void setRole_id(int role_id) {
        this.roleId = role_id;
    }

    public String getRole_name() {
        return roleName;
    }

    public void setRole_name(String role_name) {
        this.roleName = role_name;
    }

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", userId=" + userId + "]";
	}

}

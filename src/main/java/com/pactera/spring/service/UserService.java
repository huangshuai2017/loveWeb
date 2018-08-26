package com.pactera.spring.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.pactera.spring.dao.UserMapper;
import com.pactera.spring.exception.NameOrPwdException;
import com.pactera.spring.exception.NullParamException;
import com.pactera.spring.model.User;

@Service
public class UserService {

	@Resource
	SqlSessionService sqlSessionService;
	
	public boolean checkUser(String name,String pwd) {
		
		UserMapper userMapper = sqlSessionService.getSession().getMapper(UserMapper.class);
		User user = null;
		if (ObjectUtils.isEmpty(user)
				|| !pwd.equals(user.getPassword())) {
			return false;
		}
		return true;
	}
	
	public void insertUser(User user) {
		UserMapper userMapper = sqlSessionService.getSession().getMapper(UserMapper.class);
		try {
			userMapper.insertUser(user);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}

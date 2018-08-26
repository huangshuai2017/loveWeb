package com.pactera.spring.service;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.PostConstruct;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqlSessionService {
	private SqlSession sqlSession;
	@PostConstruct
	private void init() {
		String mybatisConf = "config/mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(mybatisConf);
			SqlSessionFactory  sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(reader,"development");
			sqlSession = sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public SqlSession getSession() {
		return sqlSession;
	}
	
	
}

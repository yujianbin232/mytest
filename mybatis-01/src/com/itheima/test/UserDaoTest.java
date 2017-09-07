package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.pojo.User;

public class UserDaoTest {
	
	SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}
	
	@Test
	public void test1(){
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.queryUserById(37);
		System.out.println(user);
	}
	
	@Test
	public void test2(){
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("小青");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("天河");
		userDao.insertUser(user);
	}
	
	
}

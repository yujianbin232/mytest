package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tools.ant.taskdefs.Input;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;

public class UserMapperTest {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void init() throws IOException{
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}
	
	@Test
	public void test1(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.queryUserById(37);
		sqlSession.close();
	}
	
	@Test
	public void test2(){
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("小白8888");
		user.setBirthday(new Date());
		user.setSex("2");
		user.setAddress("广州");
		mapper.insertUser(user);
		sqlSession.close();
	}
	
}

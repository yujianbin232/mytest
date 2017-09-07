package com.itheima.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory SqlSessionFactory;
	public UserDaoImpl(org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory) {
		super();
		SqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User queryUserById(Integer id) {
		SqlSession sqlSession = SqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.queryUserById", id);
		sqlSession.close();
		
		return user;
	}

	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = SqlSessionFactory.openSession(true);
		sqlSession.insert("test.insertUser", user);
		sqlSession.close();
	}

}

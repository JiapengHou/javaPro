package com.itheima.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> users= sqlSession.selectList("com.itheima.dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }

    @Override
    public void addUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.dao.IUserDao.addUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.dao.IUserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteUser(Integer id) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.itheima.dao.IUserDao.deleteUser",id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public User findById(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        User users= sqlSession.selectOne("com.itheima.dao.IUserDao.findById",userId);
        sqlSession.close();
        return users;
    }

    @Override
    public List<User> findByName(String name) {
        SqlSession sqlSession = factory.openSession();
        List<User> users= sqlSession.selectList("com.itheima.dao.IUserDao.findByName",name);
        sqlSession.close();
        return users;
    }

    @Override
    public int findTotal() {
        SqlSession sqlSession = factory.openSession();
        Integer integer= sqlSession.selectOne("com.itheima.dao.IUserDao.findTotal");
        sqlSession.close();
        return integer;
    }
}

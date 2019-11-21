package com.atheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import com.itheima.impl.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 使用工厂对象，创建dao对象

        userDao = new UserDaoImpl(factory);
    }

    @After
    public void clossSes() throws Exception{
        in.close();
    }

    @Test
    public void testFindAll() throws Exception{
//        //1. 读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2. 创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3. 使用工厂生产SqlSession对象
//        SqlSession sqlSession = factory.openSession();
//        //4. 使用代理对象执行方法
//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        List<User> users=userDao.findAll();
        for(User user: users){
            System.out.println(user);
        }
//        //6. 释放资源
//        sqlSession.close();
//        in.close();
    }


    @Test
    public void testSave() throws Exception{
        User user = new User();
        user.setUsernae("DaoIml");
        user.setAddress("南京市消防去");
        user.setSex("F");
        user.setBirthday(new Date());

//        //1. 读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2. 创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        //3. 使用工厂生产SqlSession对象
//        SqlSession sqlSession = factory.openSession();
//        //4. 使用代理对象执行方法
//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //5. 使用代理对象执行方法
        userDao.addUser(user);

//        //提交事务
//        sqlSession.commit();
//        //6. 释放资源
//        sqlSession.close();
//        in.close();
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(14);
        user.setUsernae("zhang小明");
        user.setAddress("南京市消防去...");
        user.setSex("M");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(14);
    }
    @Test
    public void testFindById(){
        User user =  userDao.findById(13);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> user =  userDao.findByName("%zhang%");
        System.out.println(user);
    }

    @Test
    public void testFindTotal(){
        int s = userDao.findTotal();
        System.out.println(s);
    }

}

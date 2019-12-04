package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     *  查询所有
     */

    List<User> findAll();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);

    User findById(Integer userId);

    List<User> findByName(String name);

    int findTotal();
}

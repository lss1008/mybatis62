package com.sangeng.dao;

import com.sangeng.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);
}

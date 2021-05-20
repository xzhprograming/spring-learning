package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    public User findById(int id);

    public List<User> findAll();
    public List<User> findOrderList();
    List<User> findAllUserAndRole();

}

package com.sangeng.dao;

import com.sangeng.pojo.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAll();

    Order findById(Integer id);
}

package com.sangeng;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sangeng.dao.OrderDao;
import com.sangeng.dao.UserDao;
import com.sangeng.pojo.Order;
import com.sangeng.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    private SqlSession session;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void testUserDao() {
        UserDao userDao = session.getMapper(UserDao.class);

//        System.out.println(userDao.findAll());
//        User user = userDao.findById(2);
//        System.out.println(user);
        PageHelper.startPage(1, 1);
        List<User> users = userDao.findAll();
        //System.out.println(users);
        System.out.println(users.get(0));
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());

        System.out.println();

    }

    @Test
    public void testOrderDao() {
        OrderDao orderDao = session.getMapper(OrderDao.class);
//        System.out.println(orderDao.findAll());
        Order order = orderDao.findById(2);
        System.out.println(order);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }

}

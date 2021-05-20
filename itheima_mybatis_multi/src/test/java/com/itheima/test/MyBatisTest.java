package com.itheima.test;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xing
 * @create 2021-05-18 21:31
 */
public class MyBatisTest {
    // 查询用户角色
    @Test
    public void test4() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mybatis框架生成的OrderMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUserAndRole = mapper.findAllUserAndRole();
        for (User user : allUserAndRole) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    // 查询用户的订单数
    @Test
    public void test3() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mybatis框架生成的OrderMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findOrderList();
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mybatis框架生成的OrderMapper接口的实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        for (User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mybatis框架生成的OrderMapper接口的实现类
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        for (Order order : orderList){
            System.out.println(order);
        }
        sqlSession.close();
    }

    @Test
    public void testProxyDao() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获得Mybatis框架生成的UserMapper接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findById(1);
        System.out.println(user);
        sqlSession.close();
    }
}

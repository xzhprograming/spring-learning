package com.itheima.test;

import com.itheima.domain.Order;
import com.itheima.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xing
 * @create 2021-05-20 11:37
 */
public class MyBatisTest2 {
    @Test
    public void testOrderSelect() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapconfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.findAll();
        System.out.println(orderList);
        sqlSession.close();
    }
}

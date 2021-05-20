package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 注解替代映射文件
 * @author xing
 * @create 2021-05-20 10:10
 */
public class MyBatisTest {

    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        // 默认加载resource文件夹下的文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findUserAndOrderAll(){
        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
        for (User user : userAndOrderAll) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setId(4);
        user.setUsername("zhangsan");
        user.setPassword("123");
        mapper.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(3);
        user.setUsername("lisi");
        user.setPassword("abc");
        mapper.update(user);
    }

    @Test
    public void testDelete(){
        mapper.delete(4);
    }

    @Test
    public void testFindById(){
        User user = mapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        System.out.println(users);
    }

}

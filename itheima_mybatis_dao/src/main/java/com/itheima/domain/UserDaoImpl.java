package com.itheima.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xing
 * @create 2021-05-18 20:41
 */
public class UserDaoImpl implements UserDao {
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        <mapper namespace="com.itheima.domain.UserMapper">
//        需要修改命名空间UserMapper
        List<User> userList = sqlSession.selectList("UserMapper.findAll");
        sqlSession.close();
        return userList;
    }

    public static void main(String[] args) throws IOException {
        UserDao userDao = new UserDaoImpl();
        List<User> all = userDao.findAll();
        System.out.println(all);
    }
}

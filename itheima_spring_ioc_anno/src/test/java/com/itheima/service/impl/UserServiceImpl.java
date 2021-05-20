package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xing
 * @create 2021-05-04 16:39
 */

//<bean id="userService" class="com.com.itheima.service.impl.UserServiceImpl">
//@Component("userService")  //实例化Bean
@Service("userService")
@Scope("singleton")
//@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

//    <property name="userDao" ref="userDao"></property> 依赖注入
//    @Autowired  // 按照数据类型从Spring容器中进行匹配
//    @Qualifier("userDao") // 按照id的值从容器中进行匹配，但是此处@Qualifier结合@Autowired一起使用
    @Resource(name = "userDao")  // 相当于@Autowired+@Qualifier
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }
}

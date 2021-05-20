package com.itheima.demo;

import com.itheima.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {

    public static void main(String[] args) {
        // 得到配置文件对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取userDao对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        // 调用UserDao类的实例方法
        userDao.save();
    }
}

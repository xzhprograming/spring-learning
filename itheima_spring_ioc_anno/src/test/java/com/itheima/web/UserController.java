package com.itheima.web;

import com.itheima.config.SpringConfiguration;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xing
 * @create 2021-05-04 17:02
 */
public class UserController {
    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserService service = (UserService) app.getBean("userService");
//        UserService service1 = app.getBean(UserService.class);  // 单个对象可用
        service.save();
    }
}

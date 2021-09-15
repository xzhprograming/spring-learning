package com.xing.learnjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xing
 * @create 2021-05-27 16:41
 */

/*
*@Component注解就相当于定义了一个Bean，它有一个可选的名称，默认是userService，即小写开头的类名。
* */
@Component
public class UserService {
//    使用@Autowired就相当于把指定类型的Bean注入到指定的字段中
    @Autowired
    MailService mailService;

    public UserService(@Autowired MailService mailService){
        this.mailService = mailService;
    }

    private List<User> users = new ArrayList<>();

    public void setUsers() {
        users.add(new User(1, "bob@example.com", "password", "Bob"));
        users.add(new User(2, "alice@example.com", "password", "Alice"));
        users.add(new User(3, "tom@example.com", "password", "Tom"));
    }

    public User login(String email, String password){
        for (User user : users){
            if(user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)){
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed!");
    }

    public User getUser(long id) {
        return users.get(0);
    }

    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}

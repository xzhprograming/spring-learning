package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    /*Bean的依赖注入的数据类型
        普通数据类型
        引用数据类型
        集合数据类型
    * */

//    集合数据类型
    private List<String> strList;
    private List<User> userList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }



//    普通数据类型
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 判断scope为singleton和prototype时，Bean的生命周期
//    public UserDaoImpl(){
//        System.out.println("UserDaoImp1创建");
//    }
//
//    public void init(){
//        System.out.println("初始化方法。。。");
//    }
//
//    public void destory(){
//        System.out.println("销毁方法。。。");
//    }

    public void save() {
        System.out.println(strList);
        System.out.println(userList);
        System.out.println(userMap);
//        System.out.println(properties);
//        System.out.println(username + "  " + age);
        System.out.println("save running....");
    }
}

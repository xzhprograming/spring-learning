package com.itheima.domain;

import java.util.List;

/**
 * @author xing
 * @create 2021-05-11 10:10
 */
public class Vo {
    private List<User> userList;

    public List<User> getUserList(){
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Vo{" +
                "userList=" + userList +
                '}';
    }
}

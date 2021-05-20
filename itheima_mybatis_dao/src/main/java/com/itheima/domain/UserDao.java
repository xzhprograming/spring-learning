package com.itheima.domain;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<User> findAll() throws IOException;
}

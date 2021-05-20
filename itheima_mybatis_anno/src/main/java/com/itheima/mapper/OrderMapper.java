package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders where uid=#{uid}")
    public List<Order> findById(int uid);

    @Select("select * from orders o, user u where o.uid = u.id;")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),

            // 一对一查询
            @Result(
                    property = "user",
                    column = "uid",  // 根据哪个字段去查询user表的数据
                    javaType = User.class, // 要封装的实体类型
                    // select属性  代表查询哪个接口的方法的数据
                    one = @One(select = "com.itheima.mapper.UserMapper.findById")
            )
    })
    public List<Order> findAll();


//    @Select("select *, o.id oid from orders o, user u where o.uid = u.id;")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//            @Result(column = "birthday", property = "user.birthday")
//    })
//    public List<Order> findAll();
}

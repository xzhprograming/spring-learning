package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author xing
 * @create 2021-05-04 10:30
 */
public class DataSourceTest {


    @Test
    // 测试spring容器产生数据源对象
    public void test4() throws PropertyVetoException, SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) app.getBean("dataSource");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }


    @Test
    // 测试手动创建c3p0数据源 (加载properties配置文件)
    public void test3() throws PropertyVetoException, SQLException {
        // 读取配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");
        // 创建数据源对象，设置连接参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    // 测试手动创建druid数据源
    public void test2() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123123");
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 测试手动创建c3p0数据源
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123123");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}

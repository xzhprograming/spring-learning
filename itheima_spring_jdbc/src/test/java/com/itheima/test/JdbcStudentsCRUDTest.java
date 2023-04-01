package com.itheima.test;

import com.itheima.domain.Students;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xing
 * @create 2021-05-12 21:50
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcStudentsCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testQueryCount(){
        Long tom = jdbcTemplate.queryForObject("select count(*) from students", Long.class);
        System.out.println(tom);
    }

    @Test
    public void testQueryOne(){
        Students tom = jdbcTemplate.queryForObject("select * from students where name=?", new BeanPropertyRowMapper<Students>(Students.class), "tom");
        System.out.println(tom);
    }

    @Test
    public void testQueryAll(){
        List<Students> students = jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<Students>(Students.class));
        System.out.println(students);
    }

    @Test
    public void testInsert(){
        jdbcTemplate.update("insert into students(class_id, name, gender, score) value (?, ?, ?, ?)", 2, "tom", "M", 89);
    }

    @Test
    public void testDelete(){
        jdbcTemplate.update("delete from students where name=?", "tom");
    }

}
